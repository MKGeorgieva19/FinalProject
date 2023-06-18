package presentationlayer.controller;

import presentationlayer.menu.AccountMenu;
import presentationlayer.menu.ErrorMenu;
import presentationlayer.menu.WelcomePageMenu;


import utils.ConsoleUtils;
import businesslayer.services.AuthenticationService;
import businesslayer.services.RegisterService;

import java.sql.SQLException;

public class MainController {
	
	private static AuthenticationController authController = new AuthenticationController();
	private static RegisterController registerController = new RegisterController();
	
	private AuthenticationService authService;
	private static RegisterService regService;
	
	public MainController() {
        this.authService = AuthenticationService.getInstance();
        this.regService = RegisterService.getInstance();
    }

	public static void run() throws SQLException {

		int n;
		
		WelcomePageMenu.welcomePage();
		
		n = ConsoleUtils.readInteger();
		
		while(n != 1 && n != 2) {
			ErrorMenu.invalidInputError();
			n = ConsoleUtils.readInteger();
		}
		
		if(n == 1) {
			
			AccountMenu.login();
			authController.run();
            LoggedUserManagementController.run();
	        
		} else if(n == 2) {
			
			regService.destroyCurrentRegisteredUser();
			AccountMenu.register();
			registerController.run();
		}
	}
}
