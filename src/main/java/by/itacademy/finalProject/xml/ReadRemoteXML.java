package by.itacademy.finalProject.xml;

import by.itacademy.finalProject.domain.Shop;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ReadRemoteXML {
    private URL source;
    private final SAXParserFactory factory = SAXParserFactory.newInstance();
    private GoodsReadSAX goodsReadSAX;

    public ReadRemoteXML(String source) {
        try {
            this.source = new URL(source);
            this.goodsReadSAX = new GoodsReadSAX(source);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public Shop execute() throws IOException {
        SAXParser saxParser;
        try {
            saxParser = factory.newSAXParser();
            ShopHandler shopHandler = new ShopHandler();
            URLConnection connection = source.openConnection();
            InputStream inputStream = connection.getInputStream();
            saxParser.parse(inputStream, shopHandler);
            Shop shop = shopHandler.getShop();
            shop.addAll(goodsReadSAX.execute());
            return shop;
        } catch (ParserConfigurationException | SAXException e) {
            throw new IOException(e);
        }
    }
}
