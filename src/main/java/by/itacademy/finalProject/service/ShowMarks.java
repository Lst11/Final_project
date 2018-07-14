package by.itacademy.finalProject.service;

import by.itacademy.finalProject.domain.Product;
import by.itacademy.finalProject.domain.Shop;

import java.util.HashMap;
import java.util.Map;

public class ShowMarks implements Operation {
    private Map<String, Double> middleMarks = new HashMap<>();

    @Override
    public void execute(Shop shop) {
        for (Product product : shop.getGoods()) {
            double result = getMiddleMark(product.getMarks());
            System.out.format("%s: %.2f%n", product.getName(), result);
            middleMarks.put(product.getName(), result);
        }
    }

    private double getMiddleMark(int[] array) {
        int sum = 0;
        for (int anArray : array) {
            sum += anArray;
        }
        return sum / (double) array.length;
    }

    public Map<String, Double> getResult() {
        return middleMarks;
    }
}
