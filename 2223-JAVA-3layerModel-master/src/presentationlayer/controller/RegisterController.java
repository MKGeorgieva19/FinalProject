package presentationlayer.controller;

import models.User;
import utils.ConsoleUtils;
import businesslayer.services.RegisterService;
import presentationlayer.menu.ErrorMenu;

import java.sql.SQLException;

public class RegisterController {
	
	LoggedUserManagementController loggedUserController = new LoggedUserManagementController();
	
	private final RegisterService regService;
	
	public RegisterController() {
        this.regService = RegisterService.getInstance();
    }
	
	public void run() throws SQLException {
		
		while(regService.getCorrectUser() == false) {

			ConsoleUtils.writeLine("USERNAME: ");
			String username = ConsoleUtils.read();

			ConsoleUtils.writeLine("PASSWORD: ");
			String password = ConsoleUtils.read();

			ConsoleUtils.writeLine("ADDRESS: ");
			String address = ConsoleUtils.read();

			ConsoleUtils.writeLine("PHONE: ");
			String phone = ConsoleUtils.read();
	        
	        ConsoleUtils.writeLine("E-MAIL: ");
	        String email = ConsoleUtils.read();
	        
	        while(!email.endsWith("@gmail.com") ^ !email.endsWith("@yahoo.com") ^ !email.endsWith("@hotmail.com") ^ !email.endsWith("@codingburgas.com") ^ !email.endsWith("@abv.bg")) {
				ErrorMenu.invalidDomain();
				ConsoleUtils.writeLine("E-MAIL: ");
		        email = ConsoleUtils.read();
		        while(email.equals("@gmail.com") ^ email.equals("@yahoo.com") ^ email.equals("@hotmail.com") ^ email.equals("@codingburgas.com") ^ email.equals("@abv.bg"))
		        {
		        	ErrorMenu.invalidEmailUsername();
		        	ConsoleUtils.writeLine("E-MAIL: ");
			        email = ConsoleUtils.read();
		        }
	        }
	        
	        regService.insertUser(username, password, address, phone, email);
	        
	        if(regService.getCorrectUser() == false) {
	        	ErrorMenu.invalidUsername();
	        }
		}
		
		ConsoleUtils.writeLine("Successful registration!");
		ConsoleUtils.write("Type 1 to back: "); int option = ConsoleUtils.readInteger();
		
		while(true) {
			switch (option) {
				case 1: {
					backToMainMenu();
					break;
				}
				default:
					ErrorMenu.invalidInputError(); option = ConsoleUtils.readInteger();
			}
		}
	}
	
	private void backToMainMenu() throws SQLException {
		MainController mainMenu = new MainController();
		mainMenu.run();
    }
}
