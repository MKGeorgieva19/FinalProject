package dataaccesslayer.repositories;

import models.Book;
import models.Category;
import utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

public class BookRepository {
    private static BookRepository instance = null;

    public static BookRepository getInstance() {

        if (BookRepository.instance == null) {
            BookRepository.instance = new BookRepository();
        }

        return BookRepository.instance;
    }

    public static List<Book> getBooks() throws SQLException{
        List<Book> books = new ArrayList<>();

        String commandString = "SELECT * FROM Books";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){
            books.add(mapToBook(resultSet));
        }
        return books;
    }

    public static Book getBookById(int bookId) throws SQLException{
        Book book = new Book();

        String commandString = "SELECT * FROM Books WHERE Id = @bookId";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        ResultSet resultSet = statement.executeQuery();

        return mapToBook(resultSet);
    }

    public static void insertIntoBook(Book book) throws SQLException{
        String commandString = "INSERT INTO Books(Title, Author, [Year], CategoryID) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(commandString)) {

            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getYear());
            statement.setInt(4, book.getCategoryId());

            int rs = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateBook(Book book) throws SQLException{
        String commandString = "UPDATE Books SET(Title = ?, Author = ?, [Year] = ?, CategoryID = ?) WHERE Id = ?";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        statement.setString(1, book.getTitle());
        statement.setString(2, book.getAuthor());
        statement.setInt(3, book.getYear());
        statement.setInt(4, book.getCategoryId());
        statement.setInt(0, book.getId());

        statement.executeUpdate();
    }

    public static void deleteBook(Book book) throws SQLException{
        String commandString = "DELETE FROM Books WHERE Id = ?";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        statement.setInt(1, book.getId());

        statement.executeUpdate();
    }

    public static Book mapToBook(ResultSet resultSet) throws SQLException{
        Book book = new Book();
        book.setId(resultSet.getInt(0));
        book.setTitle(resultSet.getString(1));
        book.setAuthor(resultSet.getString(2));
        book.setYear(resultSet.getInt(3));
        book.setCategoryId(resultSet.getInt(4));
        return book;
    }
}