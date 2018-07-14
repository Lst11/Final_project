package by.itacademy.finalProject.json;

import by.itacademy.finalProject.domain.Shop;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ReadRemoteJSONTest {
    @Test
    public void localReadValid() throws IOException {
        ReadRemoteJSON read = new ReadRemoteJSON("https://raw.githubusercontent.com/Lst11/Resource/master/Products.json");
        Shop shop = read.execute();
        Assert.assertNotNull(shop);
        Assert.assertEquals(6, shop.getGoods().size());
    }
}
