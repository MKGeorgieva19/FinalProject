package presentationlayer.menu;

import utils.ConsoleUtils;

public class ListMenu {

	public static void allBooksMenu() {
		
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                   List of all uploaded books                     |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
	}
	
	public static void allUsersMenu() {
		
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                        List of all users                         |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
	}

	public static void allGenresMenu() {

		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                   List of all uploaded genres                    |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
	}

	public static void insertBook() {
		
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                             Add book                             |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
	}

	public static void insertCategory() {

		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                             Add genre                            |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
	}

	public static void insertReservation() {

		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                          Reserve a book                          |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
	}
	
	public static void deletePersonalAccountMenu() {
		
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
		ConsoleUtils.writeLine("|                     Delete personal account                      |");
		ConsoleUtils.writeLine("+------------------------------------------------------------------+");
	}
}
