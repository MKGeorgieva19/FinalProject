package dataaccesslayer.repositories;

import models.Book;
import models.Reservation;
import models.Category;
import utils.DBConnection;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

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

    public static void insertIntoReservation(Reservation reservation) throws SQLException{
        String commandString = "INSERT INTO Reservations(BookId, UserId, ReservationDate) VALUES (?, ?, ?)";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);
        statement.setInt(1, reservation.getBookId());
        statement.setInt(2, reservation.getUserId());
        statement.setDate(3, (Date) reservation.getReservationDate());

        statement.executeUpdate();
    }

    public static void updateReservation(Reservation reservation) throws SQLException{
        String commandString = "UPDATE Reservations SET(BookId = ?, UserId = ?, ReservationDate = ?) WHERE Id = ?";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        statement.setInt(1, reservation.getBookId());
        statement.setInt(2, reservation.getUserId());
        statement.setDate(3, (Date) reservation.getReservationDate());
        statement.setInt(0, reservation.getId());

        statement.executeUpdate();
    }
    public static void deleteReservation(Reservation reservation) throws SQLException{
        String commandString = "DELETE FROM Reservations WHERE Id = ?";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        statement.setInt(1, reservation.getId());

        statement.executeUpdate();
    }

    public static Reservation mapToReservation(ResultSet resultSet) throws SQLException{
        Reservation reservation = new Reservation();
        reservation.setId(resultSet.getInt(0));
        reservation.setBookId(resultSet.getInt(1));
        reservation.setUserId(resultSet.getInt(2));
        reservation.setReservationDate(resultSet.getDate(3));
        return reservation;
    }
}