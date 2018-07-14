package by.itacademy.finalProject.service;

import by.itacademy.finalProject.domain.Product;
import by.itacademy.finalProject.domain.Shop;

import java.util.Scanner;

public class SearchGoodsByName implements Operation {
    private final Scanner in = new Scanner(System.in);
    private Product foundProduct;

    @Override
    public void execute(Shop shop) {
        System.out.println("Input the name of the product:");
        String name = in.nextLine();
        searchByName(name, shop);
    }

    public void searchByName(String name, Shop shop) {
        for (Product product : shop.getGoods()) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println("The result of search is:\n" + product);
                foundProduct = product;
            }
        }
        if (foundProduct == null) System.out.println("There are no suitable products!");
    }

    public Product getResult() {
        return foundProduct;
    }
}
