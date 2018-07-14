package by.itacademy.finalProject.service;

import by.itacademy.finalProject.domain.Product;
import by.itacademy.finalProject.domain.Shop;
import by.itacademy.finalProject.json.ReadRemoteJSON;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class SearchForSimilarProductTest {
    private SearchForSimilarProduct search  = new SearchForSimilarProduct();
    private ReadRemoteJSON read = new ReadRemoteJSON("https://raw.githubusercontent.com/Lst11/Resource/master/Products.json");
    private Shop shop;

    @Before
    public void setUp() throws IOException {
        shop = read.execute();
    }

    @Test
    public void searchValid() {
        Product product = (new Product.ProductBuilder().name("Bag").group("clothes")).build();
        search.findProductsByGroup(shop, product);
        List<Product> result = search.getResult();
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("clothes", result.get(0).getGroup());
    }

    @Test
    public void searchInvalid() {
        Product product = (new Product.ProductBuilder().name("Some new name").group("some new group")).build();
        search.findProductsByGroup(shop, product);
        List<Product> result = search.getResult();
        Assert.assertEquals(0, result.size());
    }
}
