package repositoriestest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import dataaccesslayer.repositories.BookRepository;
import models.Book;
import org.junit.jupiter.api.Test;

class getAllBooksTest {

    @Test
    void getAllBooksTest() throws SQLException {
        BookRepository test= new BookRepository();
        List<Book>tests=test.getAllBooks();
        assertNotNull(tests);

    }
}