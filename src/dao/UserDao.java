package dao;

import com.mysql.jdbc.Statement;
import connection.ConnectionManager;
import entity.User;
import entity.UserRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao {

    private static final String USERS_TABLE_NAME = "u";
    private static UserDao INSTANCE = null;

    private UserDao() {}

    public static UserDao getInstance() {
        if (INSTANCE == null) {
            synchronized (UserDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UserDao();
                }
            }
        }
        return INSTANCE;
    }
    public User create(User user) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO user (username, userpassword, useremail, role) " +
                            "VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getUserRole().toString());
                preparedStatement.executeUpdate();

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void changeUserRole(long userId, String newUserRole) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE user SET role=? WHERE id=?"))
            {
                preparedStatement.setString(1, newUserRole);
                preparedStatement.setLong(2, userId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM user u;")) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        users.add(createUserFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public Optional<User> findByEmail(String email) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM user u WHERE u.useremail = ?")) {
                preparedStatement.setString(1, email);
                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return Optional.of(createUserFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<User> findByUserName(String username) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM user u WHERE u.username = ?")) {
                preparedStatement.setString(1, username);

                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.println("searchuser");
                        return Optional.of(createUserFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Optional<User> findByUserId(long userId) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM user u WHERE u.id = ?")) {
                preparedStatement.setLong(1, userId);
                try(ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return Optional.of(createUserFromResultSet(resultSet));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void deleteUser(long userId) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM user WHERE id = ?")) {
                preparedStatement.setLong(1, userId);
                preparedStatement.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User createUserFromResultSet(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getLong(USERS_TABLE_NAME + ".id"),
                resultSet.getString(USERS_TABLE_NAME + ".username"),
                resultSet.getString(USERS_TABLE_NAME + ".userpassword"),
                resultSet.getString(USERS_TABLE_NAME + ".useremail"),
                UserRole.valueOf(resultSet.getString(USERS_TABLE_NAME + ".role")));
    }

    public void deleteUserCoinDescription(long userId) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM user_coindescription WHERE user_id = ?")) {
                preparedStatement.setLong(1, userId);
                preparedStatement.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUserSale(long userId) {
        try (Connection connection = ConnectionManager.getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM sale, user_coindescription USING sale, user_coindescription " +
                            "WHERE sale.user_coin_id = user_coindescription.id AND user_coindescription.user_id = ?;")) {
                preparedStatement.setLong(1, userId);
                preparedStatement.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
