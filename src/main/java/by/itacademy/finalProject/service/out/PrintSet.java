package by.itacademy.finalProject.service.out;

import by.itacademy.finalProject.domain.Product;

import java.util.Set;

public class PrintSet {
    public void execute(Set<Product> sortedGoods) {
        System.out.println("The list after the sorting is:");
        for (Product product : sortedGoods) {
            System.out.println(product);
        }
    }
}
