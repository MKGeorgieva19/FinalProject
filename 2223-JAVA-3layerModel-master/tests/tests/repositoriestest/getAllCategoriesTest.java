package repositoriestest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;


import dataaccesslayer.repositories.CategoryRepository;
import models.Category;
import org.junit.jupiter.api.Test;

class getAllCategoriesTest {

    @Test
    void getAllCategoriesTest() throws SQLException {
        CategoryRepository test= new CategoryRepository();
        List<Category>tests=test.getAllCategories();
        assertNotNull(tests);

    }
}