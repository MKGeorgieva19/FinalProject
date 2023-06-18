package dataaccesslayer.repositories;


import models.User;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRepository {

    private static UserRepository instance = null;

    public static UserRepository getInstance() {

        if (UserRepository.instance == null) {
            UserRepository.instance = new UserRepository();
        }

        return UserRepository.instance;
    }
    public static ArrayList<User> getAllUsers() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        String commandString = "SELECT * FROM Users";

        Connection connection = DBConnection.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(commandString);

        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            users.add(mapToUser(resultSet));
        }

        return users;
    }
    public static User getUserById(int userId) throws SQLException{
        User user = new User();

        String commandString = "SELECT * FROM Users WHERE Id = @userId";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        ResultSet resultSet = statement.executeQuery();

        return mapToUser(resultSet);
    }

    public static boolean insertInto(User user) throws SQLException {
        String commandString = "INSERT INTO Users(Username, [Password], [Address], Phone, Email) VALUES(?, ?, ?, ?, ?)";
        String commandString1 = "SELECT * FROM Users WHERE Username = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(commandString);
             PreparedStatement preparedStatement1 = conn.prepareStatement(commandString1)) {

            preparedStatement1.setString(1, user.getUsername());

            ResultSet resultSet = preparedStatement1.executeQuery();

            if(resultSet.next()) {
                return false;
            }
            else {
                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getAddress());
                preparedStatement.setString(4, user.getPhone());
                preparedStatement.setString(5, user.getEmail());

                int rs = preparedStatement.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void updateUser(User user) throws SQLException {
        String commandString = "UPDATE Users SET(Username = ?, [Password] = ?, [Address] = ?, Phone = ?, Email = ?) WHERE Id = ?";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        statement.setInt(0, user.getId());
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getAddress());
        statement.setString(4, user.getPhone());
        statement.setString(5, user.getEmail());

        statement.executeUpdate();
    }

    public static void deleteUserById(int userId) {
        String query1 = "DELETE FROM users WHERE UserId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst1 = conn.prepareStatement(query1)) {

            pst1.setInt(1, userId);

            int rs = pst1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User mapToUser(ResultSet resultSet) throws SQLException {
        User user = new User();

        user.setId(resultSet.getInt(0));
        user.setUsername(resultSet.getString(1));
        user.setPassword(resultSet.getString(2));
        user.setAddress(resultSet.getString(3));
        user.setPhone(resultSet.getString(4));
        user.setEmail(resultSet.getString(5));

        return user;
    }

    public User getRegisteredUser(String username, String password) {
        User user = null;
        String commandString = "SELECT * FROM Users WHERE Username = ? AND [Password] = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = getPreparedStatementWithUsername(connection, commandString, username);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                user = mapToUser(resultSet);
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return user;
    }

    private PreparedStatement getPreparedStatementWithUsername(Connection connection, String query, String username) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        return preparedStatement;
    }

}