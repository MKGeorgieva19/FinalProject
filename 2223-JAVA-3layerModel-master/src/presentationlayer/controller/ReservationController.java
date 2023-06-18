package presentationlayer.controller;

import businesslayer.services.ReservationService;
import models.Reservation;
import models.User;
import presentationlayer.menu.ErrorMenu;
import presentationlayer.menu.ListMenu;
import utils.ConsoleUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReservationController {

    public static void insertReservation() throws SQLException {
        ListMenu.insertReservation();
        System.out.println();
        BookController.viewAllBooks();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose the book : ");
        int n = scanner.nextInt();

        System.out.print("Type your username: ");
        String username = scanner.nextLine();
        int id = 0;

        ArrayList<User> users = new ArrayList<>();
        for (User user:users) {
            if(user.getUsername().equals(username)){
                id = user.getId();
            }
        }

        System.out.print("Write the month: ");
        String month = scanner.nextLine();
        System.out.print("Write the day: ");
        String day = scanner.nextLine();
        System.out.print("Write the year: ");
        String year = scanner.nextLine();

        String reservationDate = (month + "/" + day + "/" + year);

        System.out.println();


        Reservation reservation = new Reservation();
        reservation.setBookId(n);
        reservation.setUserId(id);
        reservation.setReservationDate(reservationDate);

        ReservationService.insertIntoReservations(reservation);

        ConsoleUtils.writeLine("Press 1 to go back:"); int option = ConsoleUtils.readInteger();
        System.out.println();

        while(true) {
            switch (option) {
                case 1: {
                    backToUserMenu();
                    break;
                }
                default:
                    ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
            }
        }
    }

    private static void backToUserMenu() throws SQLException {
        LoggedUserManagementController loggedUserManagementController = new LoggedUserManagementController();
        loggedUserManagementController.run();
    }
}
