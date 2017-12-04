package dao;

import com.mysql.jdbc.Statement;
import connection.ConnectionManager;
import entity.Country;
import entity.Series;
import entity.Theme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public final class SeriesDao {
    private static final String SERIES_TABLE_NAME = "s";
    private static final String THEME_TABLE_NAME = "t";
    private static final String COUNTRY_TABLE_NAME = "cnt";
    private static SeriesDao INSTANCE = null;

    private SeriesDao() {}

    public static SeriesDao getInstance() {
        if (INSTANCE == null) {
            synchronized (SeriesDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SeriesDao();
                }
            }
        }
        return INSTANCE;
    }

    public Series create(Series series) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO series (name, theme_id) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, series.getName());
                preparedStatement.setLong(2, series.getTheme().getId());
                preparedStatement.executeUpdate();

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    series.setId(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return series;
    }

    public List<Series> findAllByCountry(long countryId) {
        List<Series> series = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT s.id, s.name, t.id, t.name, cnt.id, cnt.name FROM series s JOIN theme t " +
                            "ON s.theme_id = t.id JOIN country cnt ON t.country_id = cnt.id AND cnt.id = ?;")) {
                preparedStatement.setLong(1, countryId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        series.add(createThemeFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return series;
    }

    private Series createThemeFromResultSet(ResultSet resultSet) throws SQLException {
        return new Series(
                resultSet.getLong(SERIES_TABLE_NAME + ".id"),
                resultSet.getString(SERIES_TABLE_NAME + ".name"),
                new Theme(resultSet.getLong(THEME_TABLE_NAME + ".id"),
                        resultSet.getString(THEME_TABLE_NAME + ".name"),
                        new Country(resultSet.getLong(COUNTRY_TABLE_NAME + ".id"),
                                resultSet.getString(COUNTRY_TABLE_NAME + ".name"))));
    }

    public List<Series> findAll() {
        List<Series> series = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM series s;")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        series.add(new Series(resultSet.getLong(SERIES_TABLE_NAME + ".id"),
                                resultSet.getString(SERIES_TABLE_NAME + ".name")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return series;
    }
}
