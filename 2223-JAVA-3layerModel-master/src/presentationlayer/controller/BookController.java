package presentationlayer.controller;

import businesslayer.services.BookService;
import businesslayer.services.CategoryService;
import models.Book;
import presentationlayer.menu.ErrorMenu;
import presentationlayer.menu.ListMenu;
import utils.ConsoleUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BookController {
    public static void viewAllBooks() throws SQLException {
        ListMenu.allBooksMenu();

        List<Book> books = BookService.getAllBooks();

        ConsoleUtils.writeLine("Book names:");
        ConsoleUtils.writeNewLine();
        books.stream().forEach(book-> {

            ConsoleUtils.writeNewLine();
            ConsoleUtils.write("Book Id: ");
            ConsoleUtils.writeInteger(book.getId());
            ConsoleUtils.write(" |  Title: ");
            ConsoleUtils.write(book.getTitle());
            ConsoleUtils.write(" |  Author: ");
            ConsoleUtils.write(book.getAuthor());
            ConsoleUtils.write(" |  Year: ");
            ConsoleUtils.writeInteger(book.getYear());
            ConsoleUtils.write(" |  Category: ");
            try {
                ConsoleUtils.writeInteger(CategoryService.getCategoryById(book.getId()).getId());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            ConsoleUtils.writeNewLine();

        });
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

    public static void addBook() throws SQLException {
        ListMenu.insertBook();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        System.out.print("Year: ");
        int year = scanner.nextInt();

        System.out.print("Choose a category by Id: ");
        int categoryId = scanner.nextInt();

        System.out.println();


        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setYear(year);
        book.setCategoryId(categoryId);

        BookService.insertIntoBooks(book);

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
