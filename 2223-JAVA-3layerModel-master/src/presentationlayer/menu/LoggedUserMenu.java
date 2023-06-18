package presentationlayer.menu;

import utils.ConsoleUtils;

public class LoggedUserMenu {

	public static void loggedUser() {
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                             Welcome!                             |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|                      Please choose a option                      |");
		ConsoleUtils.writeLine("|        __________________________________________________        |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|                       1. View all books                          |");
		ConsoleUtils.writeLine("|                       2. Book a reservation                      |");
		ConsoleUtils.writeLine("|                       3. View all genres                         |");
		ConsoleUtils.writeLine("|                       4. Add a book                              |");
		ConsoleUtils.writeLine("|                       5. Add genre                               |");
		ConsoleUtils.writeLine("|        __________________________________________________        |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|                             ACCOUNT                              |");
		ConsoleUtils.writeLine("|              ______________________________________              |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|                       6. DELETE account                          |");
		ConsoleUtils.writeLine("|                       7. Log out                                 |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		
		ConsoleUtils.write("Please choose: ");
	}
}
