package by.itacademy.finalProject.json;

import by.itacademy.finalProject.domain.Shop;
import by.itacademy.finalProject.service.SearchGoodsByPrice;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadRemoteJSON {
    private static Logger LOGGER = Logger.getLogger(ReadRemoteJSON.class.getName());
    private URL source;

    public ReadRemoteJSON(String source) {
        try {
            this.source = new URL(source);
        } catch (MalformedURLException e) {
            LOGGER.log(Level.INFO, e.getMessage());
        }
    }

    public Shop execute() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        URLConnection connection = source.openConnection();
        InputStream inputStream = connection.getInputStream();
        Shop shop = mapper.readValue(inputStream, Shop.class);
        return shop;
    }
}
