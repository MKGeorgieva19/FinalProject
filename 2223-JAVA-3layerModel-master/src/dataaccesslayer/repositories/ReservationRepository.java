package dataaccesslayer.repositories;

import models.Reservation;
import utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ReservationRepository {
    private static ReservationRepository instance = null;

    public static ReservationRepository getInstance() {

        if (ReservationRepository.instance == null) {
            ReservationRepository.instance = new ReservationRepository();
        }

        return ReservationRepository.instance;
    }
    public static ArrayList<Reservation> getAllReservations() throws SQLException {
        ArrayList<Reservation> reservations = new ArrayList<>();
        String commandString = "SELECT * FROM Reservations";

        Connection connection = DBConnection.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement(commandString);

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
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

    public void insertInto(int bookId, int userId, Date reservationDate) throws SQLException {
        String commandString = "INSERT INTO movies (BookId, UserId, ReservationDate) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement statement = conn.prepareStatement(commandString)) {

            statement.setInt(1, bookId);
            statement.setInt(2, userId);
            statement.setDate(3, (java.sql.Date) reservationDate);

            int rs = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateReservation(Reservation reservation) throws SQLException {
        String commandString = "UPDATE Reservations SET(BookId = ?, UserId = ?, ReservationDate = ?) WHERE Id = ?";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        statement.setInt(0, reservation.getId());
        statement.setInt(1, reservation.getBookId());
        statement.setInt(2, reservation.getUserId());
        statement.setDate(3, (java.sql.Date) reservation.getReservationDate());

        statement.executeUpdate();
    }

    public static void deleteReservation(Reservation reservation) throws SQLException {
        String commandString = "DELETE FROM Reservations WHERE Id = ?";

        Connection connection = DBConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(commandString);

        statement.setInt(1, reservation.getId());

        statement.executeUpdate();
    }

    public static Reservation mapToReservation(ResultSet resultSet) throws SQLException {
        Reservation reservation = new Reservation();

        reservation.setId(resultSet.getInt(0));
        reservation.setBookId(resultSet.getInt(1));
        reservation.setUserId(resultSet.getInt(2));
        reservation.setReservationDate(resultSet.getDate(3));

        return reservation;
    }
}