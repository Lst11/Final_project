package by.itacademy.finalProject.service;

import by.itacademy.finalProject.domain.Product;
import by.itacademy.finalProject.json.ReadRemoteJSON;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class SortGoodsByNameTest {
    @Test
    public void sortValid() throws IOException {
        SortGoodsByName sort = new SortGoodsByName();
        sort.execute(new ReadRemoteJSON("https://raw.githubusercontent.com/Lst11/Resource/master/Products.json").execute());
        List<Product> products = sort.getResult();
        Assert.assertEquals("Bag", products.get(0).getName());
        Assert.assertEquals("Milk", products.get(products.size() - 1).getName());
    }
}
