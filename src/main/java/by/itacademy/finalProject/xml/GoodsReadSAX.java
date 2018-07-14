package by.itacademy.finalProject.xml;

import by.itacademy.finalProject.domain.Product;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;

public class GoodsReadSAX {
    private URL source;
    private final SAXParserFactory factory = SAXParserFactory.newInstance();

    public GoodsReadSAX(String source) throws MalformedURLException {
        this.source = new URL(source);
    }

    public Set<Product> execute() throws IOException {
        SAXParser saxParser;
        try {
            saxParser = factory.newSAXParser();
            GoodsHandler goodsHandler = new GoodsHandler();
            URLConnection connection = source.openConnection();
            InputStream inputStream = connection.getInputStream();
            saxParser.parse(inputStream, goodsHandler);
            return goodsHandler.getGoods();
        } catch (ParserConfigurationException | SAXException e) {
            throw new IOException(e);
        }
    }
}
