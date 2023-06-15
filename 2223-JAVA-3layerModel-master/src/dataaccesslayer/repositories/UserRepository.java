package dataaccesslayer.repositories;

import models.User;
import utils.DBConnection;

import java.sql.*;
import java.util.List;

public class UserRepository {
    public static List<User> getUsers() throws SQLException{
        List<User> users = null;

        String commandString = "SELECT * FROM Users";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){
            users.add(mapToUser(resultSet));
        }
        return users;
    }

    public static User getUserById(int userId) throws SQLException{
        User guest = new User();

        String commandString = "SELECT * FROM Users WHERE Id = @userId";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        ResultSet resultSet = statement.executeQuery();

        return mapToUser(resultSet);
    }

    public static void insertIntoUser(User user) throws SQLException{
        String commandString = "INSERT INTO Users([Name], [Address], Phone, Email) VALUES (?, ?, ?, ?)";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);
        statement.setString(1, user.getName());
        statement.setString(2, user.getAddress());
        statement.setString(3, user.getPhone());
        statement.setString(4, user.getEmail());

        statement.executeUpdate();
    }

    public static void updateUser(User user) throws SQLException{
        String commandString = "UPDATE Users SET([Name] = ?, [Address] = ?, Phone = ?, Email = ?) WHERE Id = ?";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        statement.setString(1, user.getName());
        statement.setString(2, user.getAddress());
        statement.setString(3, user.getPhone());
        statement.setString(4, user.getEmail());
        statement.setInt(0, user.getId());

        statement.executeUpdate();
    }

    public static void deleteUser(User user) throws SQLException{
        String commandString = "DELETE FROM Users WHERE Id = ?";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        statement.setInt(1, user.getId());

        statement.executeUpdate();
    }

    public static User mapToUser(ResultSet resultSet) throws SQLException{
        User user = new User();
        user.setId(resultSet.getInt(0));
        user.setName(resultSet.getString(1));
        user.setAddress(resultSet.getString(2));
        user.setPhone(resultSet.getString(3));
        user.setEmail(resultSet.getString(4));
        return user;
    }
}