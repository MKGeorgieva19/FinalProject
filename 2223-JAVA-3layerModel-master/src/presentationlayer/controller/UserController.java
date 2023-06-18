package presentationlayer.controller;

import java.sql.SQLException;
import java.util.List;

import presentationlayer.menu.ErrorMenu;
import models.User;
import businesslayer.services.AuthenticationService;
import businesslayer.services.UserService;
import presentationlayer.menu.ListMenu;
import utils.ConsoleUtils;

public class UserController {
	
	private final UserService userService;
	private static AuthenticationService authService = null;
	
	static User user = null;
	
	public UserController() {
		this.userService = UserService.getInstance();
		this.authService = AuthenticationService.getInstance();	
    }
	
	public void viewAllUsers() throws SQLException {
		
		ListMenu.allUsersMenu();
		
		List<User> users = UserService.getAllUsers();
		
		ConsoleUtils.writeLine("User names:");
		ConsoleUtils.writeNewLine();
		users.stream().forEach(user-> {
		
			ConsoleUtils.writeNewLine();
			ConsoleUtils.write("User Id: ");
			ConsoleUtils.writeInteger(user.getId());
			ConsoleUtils.write(" |  Username: ");
			ConsoleUtils.write(user.getUsername());
			ConsoleUtils.write(" |  Password: ");
			ConsoleUtils.write(user.getPassword());
			ConsoleUtils.write(" |  Phone: ");
			ConsoleUtils.write(user.getPhone());
			ConsoleUtils.write(" |  Email: ");
			ConsoleUtils.write(user.getEmail());
			ConsoleUtils.writeNewLine();
		
		});
		
		
		ConsoleUtils.writeNewLine();
		 
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

	public static void deletePersonalAccountById() throws SQLException {
		
		ConsoleUtils.writeNewLine();
		ListMenu.deletePersonalAccountMenu();
		ConsoleUtils.writeNewLine();
		
		ConsoleUtils.writeLine("All the data will be deleted!!!");
		ConsoleUtils.writeNewLine();
		ConsoleUtils.writeLine("Are you sure you want to delete your account?");
		ConsoleUtils.writeLine("Yes or No");
		ConsoleUtils.write("Choose: "); String optionYesOrNo = ConsoleUtils.read();
		
		while(true) {
			switch (optionYesOrNo) {
				case "Yes": {
					
					User user = authService.getLoggedUser();
					
					ConsoleUtils.writeNewLine();
					ConsoleUtils.writeLine("Successfully deleted!");
					ConsoleUtils.write("Type 1 to back: "); int option = ConsoleUtils.readInteger();
					ConsoleUtils.writeNewLine();
					
					while(true) {
						switch (option) {
						case 1:
							authService.destroySession();
							backToMainMenu();
							break;
	
						default:
							ConsoleUtils.writeNewLine();
							ErrorMenu.invalidInputError();
							ConsoleUtils.write("Type 1 to back: "); option = ConsoleUtils.readInteger();
						}
					}
				}
				case "No": {
					
					ConsoleUtils.writeNewLine();
					ConsoleUtils.writeLine("You canceled the deletion!");
					ConsoleUtils.write("Type 1 to back: "); int option = ConsoleUtils.readInteger();
					ConsoleUtils.writeNewLine();
					
					while(true) {
						switch (option) {
						case 1:

						    user = authService.getLoggedUser();
							backToUserMenu();
							break;
	
						default:
							ConsoleUtils.writeNewLine();
							ErrorMenu.invalidInputError();
							ConsoleUtils.write("Type 1 to back: "); option = ConsoleUtils.readInteger();
						}
					}
				}
				default:
					ErrorMenu.invalidDataError(); 
					ConsoleUtils.writeLine("Yes or No");
					ConsoleUtils.write("Choose: "); optionYesOrNo = ConsoleUtils.read();
			}
		}
	}

	private static void backToMainMenu() throws SQLException {
		MainController mainMenu = new MainController();
		mainMenu.run();
    }
	
	private static void backToUserMenu() throws SQLException {
		LoggedUserManagementController loggedUserManagementController = new LoggedUserManagementController();
		loggedUserManagementController.run();
    }
}
