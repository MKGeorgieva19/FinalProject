package dataaccesslayer.repositories;

import models.Category;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    private static CategoryRepository instance = null;
    public static CategoryRepository getInstance() {

        if (CategoryRepository.instance == null) {
            CategoryRepository.instance = new CategoryRepository();
        }

        return CategoryRepository.instance;
    }

    public static List<Category> getAllCategories() throws SQLException{
        List<Category> categories = new ArrayList<>();
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

    public static void insertInto(Category category) throws SQLException{
        String commandString = "INSERT INTO Categories([Name]) VALUES (?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(commandString)) {

            statement.setString(1, category.getName());

            int rs = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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