package presentationlayer.controller;

import presentationlayer.menu.ErrorMenu;
import presentationlayer.menu.LoggedUserMenu;
import utils.ConsoleUtils;

import businesslayer.services.AuthenticationService;

import java.sql.SQLException;

public class LoggedUserManagementController {
	
	private static AuthenticationService authenticationService;

	static {
		authenticationService = null;
	}

	public LoggedUserManagementController() {
		this.authenticationService = AuthenticationService.getInstance();
		
	}

	public static void run() throws SQLException {
		
		LoggedUserMenu.loggedUser();
		
		int choice = ConsoleUtils.readInteger();
		
		while(true) {
			switch (choice) {
				case 1: {
					viewAllBooks();
					break;
				}
				case 2: {
					bookReservation();
					break;
				}
				case 3: {
					viewByCategory();
					break;
				}
				case 4: {
					addBooks();
					break;
				}
				case 5: {
					addCategory();
					break;
				}
				case 6: {
					deletePersonalAccountById();
					break;
				}
				case 7: {
					authenticationService.destroySession();
					backToMainMenu();
					break;
				}
				default:
					ErrorMenu.invalidInputError();
					choice = ConsoleUtils.readInteger();
					break;
			}
		}
	}
	
	private static void viewAllBooks() throws SQLException {
		BookController.viewAllBooks();
    }
	
	private static void addBooks() throws SQLException {
		BookController.addBook();
    }
	
	private static void backToMainMenu() throws SQLException {
		MainController.run();
    }
	
	private static void bookReservation() throws SQLException{
		ReservationController.insertReservation();
	}

	private static void viewByCategory() throws SQLException{
		CategoryController.viewAllCategories();
	}

	private static void addCategory() throws SQLException{
		CategoryController.addCategory();
	}

	private static void deletePersonalAccountById() throws SQLException{
		UserController.deletePersonalAccountById();
	}
}