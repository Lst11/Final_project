package by.itacademy.finalProject.service.in;

import by.itacademy.finalProject.domain.Administrator;
import by.itacademy.finalProject.service.SearchGoodsByPrice;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShopReadThread implements Runnable {
    private static Logger LOGGER = Logger.getLogger(ShopReadThread.class.getName());
    private Administrator administrator;

    public ShopReadThread(Administrator administrator) {
        this.administrator = administrator;
    }

    @Override
    public void run() {
        try {
            administrator.readRemoteShop();
        } catch (IOException e) {
            LOGGER.log(Level.INFO, e.getMessage());
            System.out.println("Unfortunately, we could not read a remote file!");
            System.exit(0);
        }
    }
}
