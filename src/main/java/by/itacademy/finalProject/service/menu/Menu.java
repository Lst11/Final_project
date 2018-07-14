package by.itacademy.finalProject.service.menu;

import by.itacademy.finalProject.domain.Administrator;
import by.itacademy.finalProject.service.in.ShopReadThread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Menu {
    private static Logger LOGGER = Logger.getLogger(Menu.class.getName());
    private final Scanner in = new Scanner(System.in);
    private volatile Administrator administrator = new Administrator();
    private final List<String> menuItems = new ArrayList<>();
    private static ShopReadThread thread;

    {
        menuItems.add("Main menu:");
        menuItems.add("1 - to sort goods by name;");
        menuItems.add("2 - to sort goods by price;");
        menuItems.add("3 - to search goods by name;");
        menuItems.add("4 - to search goods by price range;");
        menuItems.add("5 - to view goods that were received within the last week;");
        menuItems.add("6 - to search the similar goods;");
        menuItems.add("7 - to see average marks of manufacturers;");
        menuItems.add("8 - to exit.");
    }


    public void start() {
        thread = new ShopReadThread(administrator);
        for (String menuItem : menuItems) {
            System.out.println(menuItem);
        }
        int choice = 0;
        try {
            new Thread(thread).start();
            choice = in.nextInt();
            administrator.getOperation(choice);
        } catch (InputMismatchException | NullPointerException e) {
            if (choice != 8) System.out.println("Input error! Try again.");
        } finally {
            checkIsEnd(choice);
        }
    }

    private void checkIsEnd(int choice) {
        if (choice == 8) {
            System.out.println("The end!");
        } else {
            System.out.println("Please press any key to return to the menu...");
            try {
                System.in.read();
            } catch (IOException e) {
                LOGGER.log(Level.INFO, e.getMessage());
            }
            in.nextLine();
            start();
        }
    }
}

