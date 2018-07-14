package by.itacademy.finalProject.service;

import by.itacademy.finalProject.domain.Product;
import by.itacademy.finalProject.json.ReadRemoteJSON;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class SearchGoodsByPriceTest {
    private ReadRemoteJSON read = new ReadRemoteJSON("https://raw.githubusercontent.com/Lst11/Resource/master/Products.json");
    private SearchGoodsByPrice search = new SearchGoodsByPrice();
    private double min = 12, max = 50;

    @Test
    public void quantityProducts() throws IOException {
        search.searchByPrice(read.execute(), min, max);
        List<Product> result = search.getResult();
        Assert.assertEquals(3, result.size());
    }

    @Test
    public void checkProductsPrice() {
        List<Product> result = search.getResult();
        for (Product product : result) {
            boolean success = false;
            if (product.getPrice() >= min && product.getPrice() <= max) {
                success = true;
            }
            Assert.assertTrue(success);
        }
    }
}
