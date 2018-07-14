package by.itacademy.finalProject.domain;

import by.itacademy.finalProject.service.*;
import by.itacademy.finalProject.xml.ReadRemoteXML;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Administrator {
    private Shop shop;
    private Map<Integer, Operation> items = new HashMap<>();
    //private ReadRemoteJSON read = new ReadRemoteJSON("https://raw.githubusercontent.com/Lst11/Resource/master/Products.json");
    private ReadRemoteXML read = new ReadRemoteXML("https://raw.githubusercontent.com/Lst11/Resource/master/Products.xml");

    {
        items.put(1, new SortGoodsByName());
        items.put(2, new SortGoodsByPrice());
        items.put(3, new SearchGoodsByName());
        items.put(4, new SearchGoodsByPrice());
        items.put(5, new SearchGoodsByDate());
        items.put(6, new SearchForSimilarProduct());
        items.put(7, new ShowMarks());
    }

    public Administrator() {
    }

    public void readRemoteShop() throws IOException {
        this.shop = read.execute();
    }

    public void getOperation(int i) {
        items.get(i).execute(shop);
    }
}
