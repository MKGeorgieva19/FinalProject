package businesslayer.services;

import dataaccesslayer.repositories.ReservationRepository;
import models.Reservation;

import java.sql.SQLException;
import java.util.List;

public class ReservationService {
    private static ReservationService instance = null;
    private static ReservationRepository userRepository = null;

    ReservationService() {
        this.userRepository = ReservationRepository.getInstance();
    }

    public static ReservationService getInstance(){

        if (ReservationService.instance == null) {
            ReservationService.instance = new ReservationService();
        }

        return ReservationService.instance;
    }

    public static List<Reservation> getAllReservations() throws SQLException {
        return ReservationRepository.getAllReservations();
    }

    public static Reservation getReservationById(int reservationId) throws SQLException{
        return ReservationRepository.getReservationById(reservationId);
    }

    public static void insertIntoReservations(Reservation reservation) throws SQLException{
        ReservationRepository.insertInto(reservation);
    }

    public static void updateReservation(Reservation reservation) throws SQLException{
        ReservationRepository.updateReservation(reservation);
    }

    public static void deleteReservation(Reservation reservation) throws SQLException {
        ReservationRepository.deleteReservation(reservation);
    }
}