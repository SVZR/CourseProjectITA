package dao;

import com.mysql.jdbc.Statement;
import connection.ConnectionManager;
import entity.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
                    "INSERT INTO news (headline, news, releasedate) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, news.getHeadline());
                preparedStatement.setString(2, news.getText());
                preparedStatement.setString(3, news.getReleaseDate().toString());
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
        String release = resultSet.getString(NEWS_TABLE_NAME + ".releasedate");
        LocalDateTime releaseDate = LocalDateTime.parse(release, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
        return new News(resultSet.getLong(NEWS_TABLE_NAME + ".id"),
                resultSet.getString(NEWS_TABLE_NAME + ".headline"),
                resultSet.getString(NEWS_TABLE_NAME + ".news"),
                releaseDate);
    }

    public void delete(News news) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM news WHERE id = ?")) {
                preparedStatement.setLong(1, news.getId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
