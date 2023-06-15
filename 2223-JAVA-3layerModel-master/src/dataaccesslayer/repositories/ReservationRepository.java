package dataaccesslayer.repositories;

import models.Reservation;
import models.Category;
import utils.DBConnection;

import java.sql.*;
import java.util.List;

public class ReservationRepository {
    public static List<Reservation> getReservations() throws SQLException{
        List<Reservation> reservations = null;

        String commandString = "SELECT * FROM Reservations";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        ResultSet resultSet = statement.executeQuery();

        while(resultSet.next()){
            reservations.add(mapToReservation(resultSet));
        }
        return reservations;
    }

    public static Reservation getReservationById(int reservationId) throws SQLException{
        Reservation reservation = new Reservation();

        String commandString = "SELECT * FROM Reservations WHERE Id = @reservationId";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        ResultSet resultSet = statement.executeQuery();

        return mapToReservation(resultSet);
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

    public static Book mapToReservation(ResultSet resultSet) throws SQLException{
        Book book = new Book();
        book.setId(resultSet.getInt(0));
        book.setTitle(resultSet.getString(1));
        book.setAuthor(resultSet.getString(2));
        book.setYear(resultSet.getInt(3));
        book.setCategoryId(resultSet.getInt(4));
        return book;
    }
}