package dao;

import com.mysql.jdbc.Statement;
import connection.ConnectionManager;
import entity.Country;
import entity.Theme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class ThemeDao {
    private static final String THEME_TABLE_NAME = "t";
    private static final String COUNTRY_TABLE_NAME = "cnt";
    private static ThemeDao INSTANCE = null;

    private ThemeDao() {}

    public static ThemeDao getInstance() {
        if (INSTANCE == null) {
            synchronized (ThemeDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ThemeDao();
                }
            }
        }
        return INSTANCE;
    }

    public Theme create(Theme theme) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO theme (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, theme.getName());
                preparedStatement.executeUpdate();

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    theme.setId(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theme;
    }

    public List<Theme> findAll() {
        List<Theme> theme = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM theme t;")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        theme.add(new Theme(resultSet.getLong(THEME_TABLE_NAME + ".id"),
                                resultSet.getString(THEME_TABLE_NAME + ".name")));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theme;
    }

    public List<Theme> findAllByCountry(long countryId) {
        List<Theme> themes = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT t.id, t.name, cnt.id, cnt.name FROM theme t JOIN country cnt " +
                            "ON t.country_id = cnt.id AND cnt.id = ?;")) {
                preparedStatement.setLong(1, countryId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        themes.add(createThemeFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return themes;
    }

    private Theme createThemeFromResultSet(ResultSet resultSet) throws SQLException {
        return new Theme(resultSet.getLong(THEME_TABLE_NAME + ".id"),
                resultSet.getString(THEME_TABLE_NAME + ".name"),
                new Country(resultSet.getLong(COUNTRY_TABLE_NAME + ".id"),
                        resultSet.getString(COUNTRY_TABLE_NAME + ".name")));
    }
}
