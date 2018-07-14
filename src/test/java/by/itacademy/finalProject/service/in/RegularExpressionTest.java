package by.itacademy.finalProject.service.in;

import org.junit.Assert;
import org.junit.Test;

public class RegularExpressionTest {
    @Test
    public void InvalidInputTest() {
        try {
            double number = new RegularExpressions().getNumber("11,6");
            Assert.assertNotNull(number);
        } catch (Exception e) {
            System.out.println("Exception :(");
        }
    }
}
