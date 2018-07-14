package by.itacademy.finalProject.service;

import by.itacademy.finalProject.json.ReadRemoteJSON;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class ShowMarksTest {
    @Test
    public void marksValid() throws IOException {
        ShowMarks showMarks = new ShowMarks();
        showMarks.execute(new ReadRemoteJSON("https://raw.githubusercontent.com/Lst11/Resource/master/Products.json").execute());
        Map<String, Double> marks = showMarks.getResult();
        Assert.assertEquals((Double) 6.8, marks.get("Car BMW"));
        Assert.assertEquals((Double) 5.5, marks.get("Dress"));
    }
}
