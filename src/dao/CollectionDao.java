package dao;

import com.mysql.jdbc.Statement;
import connection.ConnectionManager;
import entity.Coin;
import entity.CoinDescription;
import entity.MyCollection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
}
