package by.itacademy.finalProject.service.out;

import by.itacademy.finalProject.domain.Product;

import java.util.List;

public class PrintResultOfTheOperation {
    public void execute(List<Product> result) {
        if (!result.isEmpty()) {
            System.out.println("There are the following suitable products:");
            for (Product product : result) {
                System.out.println(product);
            }
        } else System.out.println("There are no suitable products!");
    }
}
