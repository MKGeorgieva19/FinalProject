package businesslayer.services;

import dataaccesslayer.repositories.CategoryRepository;
import models.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    private static CategoryService instance = null;
    private static CategoryRepository userRepository = null;

    CategoryService() {
        this.userRepository = CategoryRepository.getInstance();
    }

    public static CategoryService getInstance(){

        if (CategoryService.instance == null) {
            CategoryService.instance = new CategoryService();
        }

        return CategoryService.instance;
    }

    public static List<Category> getAllCategories() throws SQLException {
        return CategoryRepository.getAllCategories();
    }

    public static Category getCategoryById(int categoryId) throws SQLException{
        return CategoryRepository.getCategoryById(categoryId);
    }

    public static void insertIntoCategories(Category category) throws SQLException{
        CategoryRepository.insertInto(category);
    }

    public static void updateCategory(Category category) throws SQLException{
        CategoryRepository.updateCategory(category);
    }

    public static void deleteCategory(Category category) throws SQLException {
        CategoryRepository.deleteCategory(category);
    }
}