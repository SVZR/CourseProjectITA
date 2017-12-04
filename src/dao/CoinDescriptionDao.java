package dao;

import com.mysql.jdbc.Statement;
import connection.ConnectionManager;
import entity.CoinDescription;
import entity.Metal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class CoinDescriptionDao {
    private static final String COINDESCRIPTION_TABLE_NAME = "cd";
    private static final String METAL_TABLE_NAME = "m";
    private static CoinDescriptionDao INSTANCE = null;

    private CoinDescriptionDao() {}

    public static CoinDescriptionDao getInstance() {
        if (INSTANCE == null) {
            synchronized (CoinDescriptionDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CoinDescriptionDao();
                }
            }
        }
        return INSTANCE;
    }

    public CoinDescription create(CoinDescription coinDescription) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO coinDescription (coin_id, metal_id, denomination, mintage, weight, diameter, image_obverse, image_reverse) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setLong(1, coinDescription.getCoin().getId());
                preparedStatement.setLong(2, coinDescription.getMetal().getId());
                preparedStatement.setLong(3, coinDescription.getDenomination());
                preparedStatement.setLong(4, coinDescription.getMintage());
                preparedStatement.setDouble(5, coinDescription.getWeight());
                preparedStatement.setDouble(6, coinDescription.getDiameter());
                preparedStatement.setString(7, coinDescription.getImageObverse());
                preparedStatement.setString(8, coinDescription.getImageReverse());
                preparedStatement.executeUpdate();

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    coinDescription.setId(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coinDescription;
    }

    public List<CoinDescription> findCoinDescriptionByCoinId(long coinId) {
        List<CoinDescription> coinDescription = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM coindescription cd JOIN metal m ON cd.metal_id = m.id AND cd.coin_id = ?;")) {
                preparedStatement.setLong(1, coinId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        coinDescription.add(createCoinDescriptionForCatalogFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return coinDescription;
    }

    private CoinDescription createCoinDescriptionForCatalogFromResultSet(ResultSet resultSet) throws SQLException {
        CoinDescription coinDescription = new CoinDescription();
        coinDescription.setId(resultSet.getLong(COINDESCRIPTION_TABLE_NAME + ".id"));
        coinDescription.setMetal(new Metal(resultSet.getLong(METAL_TABLE_NAME + ".id"),
                resultSet.getString(METAL_TABLE_NAME + ".name")));
        coinDescription.setDenomination(resultSet.getLong(COINDESCRIPTION_TABLE_NAME + ".denomination"));
        coinDescription.setWeight(resultSet.getDouble(COINDESCRIPTION_TABLE_NAME + ".weight"));
        coinDescription.setDiameter(resultSet.getDouble(COINDESCRIPTION_TABLE_NAME + ".diameter"));
        coinDescription.setImageObverse(resultSet.getString(COINDESCRIPTION_TABLE_NAME + ".image_obverse"));
        coinDescription.setImageReverse(resultSet.getString(COINDESCRIPTION_TABLE_NAME + ".image_reverse"));
        return coinDescription;
    }

    private CoinDescription createCoinDescriptionFromResultSet(ResultSet resultSet) throws SQLException {
//        return new CoinDescription(
//                resultSet.getLong(COINDESCRIPTION_TABLE_NAME + ".id"),
//                resultSet.getLong(COINDESCRIPTION_TABLE_NAME + ".coin_id"),
//                resultSet.getLong(COINDESCRIPTION_TABLE_NAME + ".metal_id"),
//                resultSet.getLong(COINDESCRIPTION_TABLE_NAME + ".denomination"),
//                resultSet.getLong(COINDESCRIPTION_TABLE_NAME + ".mintage"),
//                resultSet.getLong(COINDESCRIPTION_TABLE_NAME + ".weight"),
//                resultSet.getLong(COINDESCRIPTION_TABLE_NAME + ".diameter"),
//                resultSet.getString(COINDESCRIPTION_TABLE_NAME + ".image"));
        return new CoinDescription();
    }
}
