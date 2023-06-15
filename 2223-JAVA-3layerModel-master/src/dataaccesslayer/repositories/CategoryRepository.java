package dataaccesslayer.repositories;

import models.Category;
import utils.DBConnection;

import java.sql.*;
import java.util.List;

public class CategoryRepository {
    public static List<Category> getCategories() throws SQLException{
        List<Category> categories = null;

        String commandString = "SELECT * FROM Categories";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){
            categories.add(mapToCategory(resultSet));
        }
        return categories;
    }

    public static Category getCategoryById(int categoryId) throws SQLException{
        Category category = new Category();

        String commandString = "SELECT * FROM Categories WHERE Id = @categoryId";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        ResultSet resultSet = statement.executeQuery();

        return mapToCategory(resultSet);
    }

    public static void insertIntoCategory(Category category) throws SQLException{
        String commandString = "INSERT INTO Categories([Name]) VALUES (?)";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);
        statement.setString(1, category.getName());

        statement.executeUpdate();
    }

    public static void updateCategory(Category category) throws SQLException{
        String commandString = "UPDATE Categories SET([Name] = ?) WHERE Id = ?";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        statement.setString(1, category.getName());
        statement.setInt(0, category.getId());

        statement.executeUpdate();
    }

    public static void deleteCategory(Category category) throws SQLException{
        String commandString = "DELETE FROM Categories WHERE Id = ?";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        statement.setInt(1, category.getId());

        statement.executeUpdate();
    }

    public static Category mapToCategory(ResultSet resultSet) throws SQLException{
        Category category = new Category();
        category.setId(resultSet.getInt(0));
        category.setName(resultSet.getString(1));
        return category;
    }
}