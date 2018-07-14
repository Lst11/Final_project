package by.itacademy.finalProject.service;

import by.itacademy.finalProject.domain.Product;
import by.itacademy.finalProject.domain.Shop;
import by.itacademy.finalProject.service.in.RegularExpressions;
import by.itacademy.finalProject.service.out.PrintResultOfTheOperation;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchGoodsByPrice implements Operation {
    private static Logger LOGGER = Logger.getLogger(SearchGoodsByPrice.class.getName());
    private final Scanner in = new Scanner(System.in);
    private List<Product> result = new ArrayList<>();
    private Double min, max;

    @Override
    public void execute(Shop shop) {
        result = new ArrayList<>();
        try {
            inputMinMax();
            if (max < min) searchByPrice(shop, max, min);
            else searchByPrice(shop, min, max);
            new PrintResultOfTheOperation().execute(result);
        } catch (NumberFormatException | InputMismatchException e) {
            LOGGER.log(Level.INFO, e.getMessage());
            System.out.println("Input error! Try again.");
        }
    }

    private void inputMinMax() {
        System.out.println("Input the minimum price for search:");
        this.min = new RegularExpressions().getNumber(in.nextLine());
        System.out.println("Input the maximum price for search:");
        this.max = new RegularExpressions().getNumber(in.nextLine());
    }

    public void searchByPrice(Shop shop, Double min, Double max) {
        for (Product product : shop.getGoods()) {
            if (product.getPrice() >= min && product.getPrice() <= max) {
                result.add(product);
            }
        }
    }

    public List<Product> getResult() {
        return result;
    }
}
