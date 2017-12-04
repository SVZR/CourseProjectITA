package dao;

import com.mysql.jdbc.Statement;
import connection.ConnectionManager;
import entity.Metal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class MetalDao {
    private static final String METAL_TABLE_NAME = "metal";
    private static MetalDao INSTANCE = null;

    private MetalDao() {}

    public static MetalDao getInstance() {
        if (INSTANCE == null) {
            synchronized (CountryDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MetalDao();
                }
            }
        }
        return INSTANCE;
    }

    public Metal create(Metal metal) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO metal (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, metal.getName());
                preparedStatement.executeUpdate();

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    metal.setId(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return metal;
    }

    public List<Metal> findAll() {
        List<Metal> metal = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM metal;")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        metal.add(createMetalFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return metal;
    }

    private Metal createMetalFromResultSet(ResultSet resultSet) throws SQLException {
        return new Metal(
                resultSet.getLong(METAL_TABLE_NAME + ".id"),
                resultSet.getString(METAL_TABLE_NAME + ".name"));
    }


}
