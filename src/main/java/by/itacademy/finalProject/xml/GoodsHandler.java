package by.itacademy.finalProject.xml;

import by.itacademy.finalProject.domain.Product;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

public class GoodsHandler extends DefaultHandler {
    private Set<Product> goods = new HashSet<>();
    private String name;
    private String description;
    private String date;
    private String price;
    private String group;
    private String marks;

    private boolean isName;
    private boolean isDescription;
    private boolean isDate;
    private boolean isPrice;
    private boolean isGroup;
    private boolean isMarks;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("name"))
            isName = true;
        else if (qName.equalsIgnoreCase("description"))
            isDescription = true;
        else if (qName.equalsIgnoreCase("date"))
            isDate = true;
        else if (qName.equalsIgnoreCase("price"))
            isPrice = true;
        else if (qName.equalsIgnoreCase("group"))
            isGroup = true;
        else if (qName.equalsIgnoreCase("marks"))
            isMarks = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("goods")) {
            try {
                goods.add(new Product(name, description, date, price, group, marks));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isName) {
            name = new String(ch, start, length);
            isName = false;
        } else if (isDescription) {
            description = new String(ch, start, length);
            isDescription = false;
        } else if (isDate) {
            date = new String(ch, start, length);
            isDate = false;
        } else if (isPrice) {
            price = new String(ch, start, length);
            isPrice = false;
        } else if (isGroup) {
            group = new String(ch, start, length);
            isGroup = false;
        } else if (isMarks) {
            marks = new String(ch, start, length);
            isMarks = false;
        }
    }

    public Set<Product> getGoods() {
        return goods;
    }
}

