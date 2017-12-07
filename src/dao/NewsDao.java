package dao;

import com.mysql.jdbc.Statement;
import connection.ConnectionManager;
import entity.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class NewsDao {
    private static final String NEWS_TABLE_NAME = "n";
    private static NewsDao INSTANCE = null;

    private NewsDao() {}

    public static NewsDao getInstance() {
        if (INSTANCE == null) {
            synchronized (NewsDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NewsDao();
                }
            }
        }
        return INSTANCE;
    }

    public News create(News news) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO news (news, releasedate) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, news.getText());
                preparedStatement.setObject(2, news.getReleaseDate());
                preparedStatement.executeUpdate();

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    news.setId(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }

    public List<News> findAllNews() {
        List<News> news = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM news n;")) {
//                preparedStatement.setObject(1, LocalDateTime.now().minusMonths(1));
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        news.add(createNewsFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }

    private News createNewsFromResultSet(ResultSet resultSet) throws SQLException {
        Object dateObject = resultSet.getObject(NEWS_TABLE_NAME + ".releasedate");
        LocalDateTime releaseDate;
        if (dateObject instanceof LocalDateTime) {
            releaseDate = (LocalDateTime) dateObject;
        } else {
            releaseDate = LocalDateTime.now();
        }
        return new News(resultSet.getLong(NEWS_TABLE_NAME + ".id"),
                resultSet.getString(NEWS_TABLE_NAME + ".news"),
                releaseDate);
    }
}
