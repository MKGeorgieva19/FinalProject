package presentationlayer.controller;

import presentationlayer.menu.AccountMenu;
import presentationlayer.menu.ErrorMenu;
import presentationlayer.menu.WelcomePageMenu;


import utils.ConsoleUtils;
import businesslayer.services.AuthenticationService;
import businesslayer.services.RegisterService;

import java.sql.SQLException;

public class MainController {
	
	private AuthenticationController authController = new AuthenticationController();
	private RegisterController registerController = new RegisterController();
	
	private AuthenticationService authService;
	private RegisterService regService;
	
	public MainController() {
        this.authService = AuthenticationService.getInstance();
        this.regService = RegisterService.getInstance();
    }

	public void run() throws SQLException {

		int optionForAccount;
		
		WelcomePageMenu.welcomePage();
		
		optionForAccount = ConsoleUtils.readInteger();
		
		while(optionForAccount != 1 && optionForAccount != 2) {
			ErrorMenu.invalidInputError();
			optionForAccount = ConsoleUtils.readInteger();
		}
		
		if(optionForAccount == 1) {
			
			AccountMenu.login();
			authController.run();
            LoggedUserManagementController loggedUserController = new LoggedUserManagementController();
			loggedUserController.run();
	        
		} else if(optionForAccount == 2) {
			
			regService.destroyCurrentRegisteredUser();
			AccountMenu.register();
			registerController.run();
		}
	}
}
