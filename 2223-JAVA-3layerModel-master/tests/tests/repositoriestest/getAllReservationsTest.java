package repositoriestest;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;


import dataaccesslayer.repositories.ReservationRepository;
import models.Reservation;
import org.junit.jupiter.api.Test;

class getAllReservationsTest {

    @Test
    void getAllReservationsTest() throws SQLException {
        ReservationRepository test= new ReservationRepository();
        List<Reservation>tests=test.getAllReservations();
        assertNotNull(tests);

    }
}