package dataaccesslayer.repositories;

import models.Book;
import models.Category;
import utils.DBConnection;

import java.sql.*;
import java.util.List;

public class BookRepository {
    public static List<Book> getBooks() throws SQLException{
        List<Book> books = null;

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

    public static void insertIntoBook(String title, String author, int year, Category category) throws SQLException{
        if(CategoryRepository.getCategoryById(category.getId()) == null) {
            CategoryRepository.insertIntoCategory(category);
        }

        Book book = new Book();

        String commandString = "INSERT INTO Books(Title, Author, [Year], CategoryID) VALUES (?, ?, ?, ?)";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);
        statement.setString(1, book.getTitle());
        statement.setString(2, book.getAuthor());
        statement.setInt(3, book.getYear());
        statement.setInt(4, category.getId());

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