package dao;

import com.mysql.jdbc.Statement;
import connection.ConnectionManager;
import entity.Coin;
import entity.Country;
import entity.Series;
import entity.Theme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class CoinDao {
    private static final String COINS_TABLE_NAME = "c";
    private static final String SERIES_TABLE_NAME = "s";
    private static final String THEME_TABLE_NAME = "t";
    private static final String COUNTRY_TABLE_NAME = "cnt";
    private static CoinDao INSTANCE = null;

    private CoinDao() {}

    public static CoinDao getInstance() {
        if (INSTANCE == null) {
            synchronized (CoinDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CoinDao();
                }
            }
        }
        return INSTANCE;
    }

    public Coin create(Coin coin) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO coin (name, series_id, releasedate, designer, mintedby, description_obverse, " +
                            "description_reverse, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, coin.getName());
                preparedStatement.setLong(2, coin.getSeries().getId());
                preparedStatement.setString(3, coin.getReleaseDate());
                preparedStatement.setString(4, coin.getDesigner());
                preparedStatement.setString(5, coin.getMintedBy());
                preparedStatement.setString(6, coin.getDescriptionObverse());
                preparedStatement.setString(7, coin.getDescriptionRevers());
                preparedStatement.setString(8, coin.getImage());
                preparedStatement.executeUpdate();

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    coin.setId(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coin;
    }

    public List<Coin> findAllCoinByCountry(long countryId) {
        List<Coin> coins = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT c.id, c.name, s.id, s.name, t.id, t.name, cnt.id, cnt.name, c.releasedate, c.designer, " +
                            "c.mintedby, c.description_obverse, c.description_reverse, c.image FROM coin c " +
                            "JOIN series s ON c.series_id = s.id JOIN theme t ON s.theme_id = t.id " +
                            "JOIN country cnt ON t.country_id = cnt.id AND cnt.id = ?;")) {
                preparedStatement.setLong(1, countryId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        coins.add(createCoinFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coins;
    }

    public Coin findCoinById(long coinId) {
        Coin coin = new Coin();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT c.id, c.name, s.id, s.name, t.id, t.name, cnt.id, cnt.name, c.releasedate, c.designer, " +
                            "c.mintedby, c.description_obverse, c.description_reverse, c.image FROM coin c " +
                            "JOIN series s ON c.series_id = s.id JOIN theme t ON s.theme_id = t.id " +
                            "JOIN country cnt ON t.country_id = cnt.id AND c.id = ?;")) {
                preparedStatement.setLong(1, coinId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        coin = createCoinFromResultSet(resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coin;
    }

    private Coin createCoinFromResultSet(ResultSet resultSet) throws SQLException {
        Coin coin = new Coin(
                resultSet.getLong(COINS_TABLE_NAME + ".id"),
                resultSet.getString(COINS_TABLE_NAME + ".name"),
                new Series(resultSet.getLong(SERIES_TABLE_NAME + ".id"),
                        resultSet.getString(SERIES_TABLE_NAME + ".name"),
                        new Theme(resultSet.getLong(THEME_TABLE_NAME + ".id"),
                                resultSet.getString(THEME_TABLE_NAME + ".name"),
                                new Country(resultSet.getLong(COUNTRY_TABLE_NAME + ".id"),
                                        resultSet.getString(COUNTRY_TABLE_NAME + ".name")))),
                resultSet.getString(COINS_TABLE_NAME + ".releasedate"),
                resultSet.getString(COINS_TABLE_NAME + ".designer"),
                resultSet.getString(COINS_TABLE_NAME + ".mintedby"),
                resultSet.getString(COINS_TABLE_NAME + ".description_obverse"),
                resultSet.getString(COINS_TABLE_NAME + ".description_reverse"),
                resultSet.getString(COINS_TABLE_NAME + ".image"));
        return coin;
    }

}
