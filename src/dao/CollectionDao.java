package dao;

import com.mysql.jdbc.Statement;
import connection.ConnectionManager;
import entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class CollectionDao {
    private static final String COLLECTION_TABLE_NAME = "uc";
    private static CollectionDao INSTANCE = null;

    private CollectionDao() {}

    public static CollectionDao getInstance() {
        if (INSTANCE == null) {
            synchronized (CollectionDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CollectionDao();
                }
            }
        }
        return INSTANCE;
    }

    public List<MyCollection> findCoinDescriptionAmountInCollectionByCoinId(long coinId, long userId) {
        List<MyCollection> myCollections = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT cd.id, uc.amount FROM coindescription cd JOIN user_coindescription uc " +
                            "ON cd.id = uc.coindescription_id JOIN coin c ON c.id = cd.coin_id AND c.id = ? " +
                            "AND uc.user_id = ?;")) {
                preparedStatement.setLong(1, coinId);
                preparedStatement.setLong(2, userId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        MyCollection cdIdAmount = new MyCollection();
                        cdIdAmount.setCoinDescription(new CoinDescription(resultSet.getLong("cd.id")));
                        cdIdAmount.setAmount(resultSet.getLong("uc.amount"));
                        myCollections.add(cdIdAmount);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myCollections;
    }

    public void addCoinToCollection(long userId, long coinDescriptionId, long amount) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO user_coindescription (user_id, coindescription_id, amount) VALUE (?, ?, ?);",
                    Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setLong(1, userId);
                preparedStatement.setLong(2, coinDescriptionId);
                preparedStatement.setLong(3, amount);
                preparedStatement.executeUpdate();

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    System.out.println(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCoinAmountInCollection(long userId, long coinDescriptionId, long amount) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE user_coindescription uc SET uc.amount = ? WHERE uc.user_id = ? AND uc.coindescription_id = ?;")) {
                preparedStatement.setLong(1, amount);
                preparedStatement.setLong(2, userId);
                preparedStatement.setLong(3, coinDescriptionId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<MyCollection> findCountryNamesAndSumCoinsInCollection(long userId) {
        List<MyCollection> myCollections = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT SUM(uc.amount), cnt.name, cnt.id FROM user_coindescription uc JOIN user u " +
                            "ON uc.user_id = u.id JOIN coindescription cd ON uc.coindescription_id = cd.id " +
                            "JOIN coin c ON cd.coin_id = c.id JOIN series s ON c.series_id = s.id " +
                            "JOIN theme t ON s.theme_id = t.id JOIN country cnt ON t.country_id = cnt.id " +
                            "AND u.id = ? GROUP BY (cnt.id);")) {
                preparedStatement.setLong(1, userId);

                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        myCollections.add(createAmountOfCoinsByCountry(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myCollections;
    }

    private MyCollection createAmountOfCoinsByCountry(ResultSet resultSet) throws SQLException {
        MyCollection myCollection = new MyCollection();
        myCollection.setAmount(resultSet.getLong(1));
        myCollection.setName(resultSet.getString("cnt.name"));
        myCollection.setId(resultSet.getLong("cnt.id"));
        return myCollection;
    }

    public List<Coin> findCoinsInCollectionByCountry(long userId, long countryId) {
        List<Coin> coins = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT c.series_id, c.id, c.name, SUM(uc.amount) FROM user_coindescription uc JOIN user u ON uc.user_id = u.id JOIN coindescription cd ON uc.coindescription_id = cd.id JOIN coin c ON cd.coin_id = c.id JOIN series s ON c.series_id = s.id JOIN theme t ON s.theme_id = t.id JOIN country cnt ON t.country_id = cnt.id AND u.id = ? AND cnt.id = ? GROUP BY c.id;")) {
                preparedStatement.setLong(1, userId);
                preparedStatement.setLong(2, countryId);

                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        coins.add(createCoinInCollection(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coins;
    }

    private Coin createCoinInCollection(ResultSet resultSet) throws SQLException {
        Coin coin = new Coin();
        coin.setId(resultSet.getLong("c.id"));
        coin.setName(resultSet.getString("c.name"));
        long seriesId = resultSet.getLong("c.series_id");
        Series series = new Series();
        series.setId(seriesId);
        coin.setSeries(series);
        coin.setAmount(resultSet.getLong("SUM(uc.amount)"));
        return coin;
    }

    public List<Theme> findThemesInCollectionByCountry(long userId, long countryId) {
        List<Theme> themes = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT t.id, t.name, SUM(uc.amount) FROM user_coindescription uc JOIN user u ON uc.user_id = u.id JOIN coindescription cd ON uc.coindescription_id = cd.id JOIN coin c ON cd.coin_id = c.id JOIN series s ON c.series_id = s.id JOIN theme t ON s.theme_id = t.id JOIN country cnt ON t.country_id = cnt.id AND u.id = ? AND cnt.id = ? GROUP BY t.id;")) {
                preparedStatement.setLong(1, userId);
                preparedStatement.setLong(2, countryId);

                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        themes.add(createThemeInCollection(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return themes;
    }

    private Theme createThemeInCollection(ResultSet resultSet) throws SQLException {
        Theme theme = new Theme();
        theme.setId(resultSet.getLong("t.id"));
        theme.setName(resultSet.getString("t.name"));
        theme.setAmount(resultSet.getLong("SUM(uc.amount)"));
        return theme;
    }

    public List<Series> findSeriesInCollectionByCountry(long userId, long countryId) {
        List<Series> series = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT s.theme_id, s.id, s.name, SUM(uc.amount) FROM user_coindescription uc JOIN user u ON uc.user_id = u.id JOIN coindescription cd ON uc.coindescription_id = cd.id JOIN coin c ON cd.coin_id = c.id JOIN series s ON c.series_id = s.id JOIN theme t ON s.theme_id = t.id JOIN country cnt ON t.country_id = cnt.id AND u.id = ? AND cnt.id = ? GROUP BY s.id;")) {
                preparedStatement.setLong(1, userId);
                preparedStatement.setLong(2, countryId);

                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        series.add(createSeriesInCollection(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return series;
    }

    private Series createSeriesInCollection(ResultSet resultSet) throws SQLException {
        Series series = new Series();
        series.setId(resultSet.getLong("s.id"));
        series.setName(resultSet.getString("s.name"));
        series.setAmount(resultSet.getLong("SUM(uc.amount)"));
        Theme theme = new Theme();
        theme.setId(resultSet.getLong("s.theme_id"));
        series.setTheme(theme);
        return series;
    }
}
