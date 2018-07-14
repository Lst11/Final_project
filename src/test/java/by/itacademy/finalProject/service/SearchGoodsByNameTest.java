package by.itacademy.finalProject.service;

import by.itacademy.finalProject.json.ReadRemoteJSON;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SearchGoodsByNameTest {
    private SearchGoodsByName search = new SearchGoodsByName();
    private ReadRemoteJSON read = new ReadRemoteJSON("https://raw.githubusercontent.com/Lst11/Resource/master/Products.json");

    @Test
    public void searchValid() throws IOException {
        search.searchByName("Bag", read.execute());
        Assert.assertEquals("Bag", search.getResult().getName());
    }

    @Test
    public void searchInvalid() throws IOException {
        search.searchByName("Some new name", read.execute());
        Assert.assertNull(search.getResult());
    }
}
