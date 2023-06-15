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

    public static boolean insertInto(User user) throws SQLException {
        String commandString = "INSERT INTO Users([Name], Gender, Username, [Password]) VALUES(?, ?, ?, ?)";
        String query2 = "SELECT * FROM Users WHERE Username = ?";
        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst1 = conn.prepareStatement(commandString);
             PreparedStatement pst2 = conn.prepareStatement(query2)) {

            pst2.setString(1, user.getUsername());

            ResultSet resultSet = pst2.executeQuery();

            if(resultSet.next()) {
                return false;
            }
            else {
                pst1.setString(1, user.getName());
                pst1.setString(2, user.getGender());
                pst1.setString(3, user.getUsername());
                pst1.setString(4, user.getPassword());

                int rs = pst1.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void updateUser(User user) throws SQLException {
        String commandString = "UPDATE Users SET([Name] = ?, Gender = ?, Username = ?, [Password] = ?) WHERE Id = ?";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        statement.setInt(0, user.getId());
        statement.setString(1, user.getName());
        statement.setString(2, user.getGender());
        statement.setString(3, user.getUsername());
        statement.setString(4, user.getPassword());

        statement.executeUpdate();
    }

    public static void deleteUser(User user) throws SQLException {
        String commandString = "DELETE FROM Users WHERE Id = ?";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        statement.setInt(1, user.getId());

        statement.executeUpdate();
    }

    public static User mapToUser(ResultSet resultSet) throws SQLException {
        User user = new User();

        user.setId(resultSet.getInt(0));
        user.setName(resultSet.getString(1));
        user.setGender(resultSet.getString(2));
        user.setUsername(resultSet.getString(3));
        user.setPassword(resultSet.getString(4));

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