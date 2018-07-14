package by.itacademy.finalProject.service;

import by.itacademy.finalProject.domain.Product;
import by.itacademy.finalProject.json.ReadRemoteJSON;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class SearchGoodsByDateTest {
    @Test
    public void searchValid() throws IOException {
        SearchGoodsByDate search = new SearchGoodsByDate();
        ReadRemoteJSON read = new ReadRemoteJSON("https://raw.githubusercontent.com/Lst11/Resource/master/Products.json");
        search.execute(read.execute());
        List<Product> result = search.getResult();
        Assert.assertEquals(1, result.size());
        for (Product product : result) {
            Assert.assertTrue(correctDate(product.getDate()));
        }
    }

    private boolean correctDate(Date date) {
        long DAY_IN_MS = 1000 * 60 * 60 * 24;
        Date weekAgo = new Date(System.currentTimeMillis() - (7 * DAY_IN_MS));
        return date.after(weekAgo);
    }

}
