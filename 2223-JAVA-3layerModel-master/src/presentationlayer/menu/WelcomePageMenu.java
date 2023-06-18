package presentationlayer.menu;

import utils.ConsoleUtils;

public class WelcomePageMenu {

	public static void welcomePage() {
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|                             WELCOME                              |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|                      DO YOU HAVE AN ACCOUNT?                     |");
		ConsoleUtils.writeLine("|        __________________________________________________        |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("|                             1. Yes                               |");
		ConsoleUtils.writeLine("|                             2. No                                |");
		ConsoleUtils.writeLine("|                                                                  |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");

		ConsoleUtils.write("Please choose: ");
	}
}
