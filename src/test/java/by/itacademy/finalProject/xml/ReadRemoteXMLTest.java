package by.itacademy.finalProject.xml;

import by.itacademy.finalProject.domain.Shop;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ReadRemoteXMLTest {
    @Test
    public void localReadValid() throws IOException {
        ReadRemoteXML read = new ReadRemoteXML("https://raw.githubusercontent.com/Lst11/Resource/master/Products.xml");
        Shop shop = read.execute();
        Assert.assertNotNull(shop);
        Assert.assertEquals(6, shop.getGoods().size());
    }
}
