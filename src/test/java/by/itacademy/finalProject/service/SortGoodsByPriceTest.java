package by.itacademy.finalProject.service;

import by.itacademy.finalProject.domain.Product;
import by.itacademy.finalProject.json.ReadRemoteJSON;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class SortGoodsByPriceTest {
    @Test
    public void sortValid() throws IOException {
        SortGoodsByPrice sort = new SortGoodsByPrice();
        sort.execute(new ReadRemoteJSON("https://raw.githubusercontent.com/Lst11/Resource/master/Products.json").execute());
        List<Product> products = sort.getResult();
        Assert.assertEquals("Milk", products.get(0).getName());
        Assert.assertEquals("Car BMW", products.get(products.size() - 1).getName());
    }
}
