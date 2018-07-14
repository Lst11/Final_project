package by.itacademy.finalProject.service.сomparators;

import by.itacademy.finalProject.domain.Product;

import java.util.Comparator;

public class NameComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
    }
}

