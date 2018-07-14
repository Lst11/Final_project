package by.itacademy.finalProject;

import by.itacademy.finalProject.service.menu.Menu;

public class App {
    private static volatile Menu instance;

    public static void main(String[] args) {
        getInstance().start();
    }

    private static Menu getInstance() {
        if (instance == null) {
            synchronized (Menu.class) {
                if (instance == null) {
                    instance = new Menu();
                }
            }
        }
        return instance;
    }
}
