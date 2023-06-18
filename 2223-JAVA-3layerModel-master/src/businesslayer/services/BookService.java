package businesslayer.services;

import dataaccesslayer.repositories.BookRepository;
import models.Book;

import java.sql.SQLException;
import java.util.List;

public class BookService {
    private static BookService instance = null;
    private static BookRepository userRepository = null;

    BookService() {
        this.userRepository = BookRepository.getInstance();
    }

    public static BookService getInstance(){

        if (BookService.instance == null) {
            BookService.instance = new BookService();
        }

        return BookService.instance;
    }

    public static List<Book> getAllBooks() throws SQLException {
        return BookRepository.getAllBooks();
    }

    public static Book getBookById(int bookId) throws SQLException{
        return BookRepository.getBookById(bookId);
    }

    public static void insertIntoBooks(Book book) throws SQLException{
        BookRepository.insertInto(book);
    }

    public static void updateBook(Book book) throws SQLException{
        BookRepository.updateBook(book);
    }

    public static void deleteBook(Book book) throws SQLException {
        BookRepository.deleteBook(book);
    }
}