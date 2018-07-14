package by.itacademy.finalProject.xml;

import by.itacademy.finalProject.domain.Shop;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ShopHandler extends DefaultHandler {
    private Shop.ShopBuilder builder = new Shop.ShopBuilder();
    private Shop shop;
    private String name;

    private boolean isName;
    private boolean isLocation;
    private boolean isEmails;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("name"))
            isName = true;
        else if (qName.equalsIgnoreCase("location"))
            isLocation = true;
        else if (qName.equalsIgnoreCase("emails"))
            isEmails = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("emails")) {
            builder.name(name);
            shop = builder.build();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isName) {
            name = new String(ch, start, length);
            isName = false;
        } else if (isLocation) {
            String location = new String(ch, start, length);
            builder.location(location);
            isLocation = false;
        } else if (isEmails) {
            String email = new String(ch, start, length);
            builder.email(email);
            isEmails = false;
        }
    }

    public Shop getShop() {
        return shop;
    }
}