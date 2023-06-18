package presentationlayer.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import models.Category;
import presentationlayer.menu.ErrorMenu;
import presentationlayer.menu.ListMenu;
import businesslayer.services.CategoryService;
import utils.ConsoleUtils;

public class CategoryController {
    private static CategoryService categoryService;

    public void CategoryService() {
        this.categoryService = CategoryService.getInstance();

    }

    public static void viewAllCategories() throws SQLException {

        ListMenu.allGenresMenu();

        List<Category> categories = categoryService.getAllCategories();

        ConsoleUtils.writeLine("Genre names:");
        ConsoleUtils.writeNewLine();
        categories.stream().forEach(category-> System.out.println(category.getName()));
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

    public static void addCategory() throws SQLException {
        ListMenu.insertCategory();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Genre Name: ");
        String name = scanner.nextLine();

        System.out.println();


        Category category = new Category();
        category.setName(name);

        CategoryService.insertIntoCategories(category);

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
