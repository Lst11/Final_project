package by.itacademy.finalProject.service.сomparators;

import by.itacademy.finalProject.domain.Product;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product product1, Product product2) {
        return Double.compare(product1.getPrice(), product2.getPrice());
    }

}
