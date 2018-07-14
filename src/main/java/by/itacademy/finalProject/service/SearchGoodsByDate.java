package by.itacademy.finalProject.service;

import by.itacademy.finalProject.domain.Product;
import by.itacademy.finalProject.domain.Shop;
import by.itacademy.finalProject.service.out.PrintResultOfTheOperation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SearchGoodsByDate implements Operation {
    private List<Product> result = new ArrayList<>();

    @Override
    public void execute(Shop shop) {
        Date lastWeek = getDayLastWeek();
        for (Product product : shop.getGoods()) {
            if (product.getDate().after(lastWeek)) {
                result.add(product);
            }
        }
        new PrintResultOfTheOperation().execute(result);
    }

    private Date getDayLastWeek() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String todate = dateFormat.format(date);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date lastWeek = cal.getTime();
        return lastWeek;
    }

    public List<Product> getResult() {
        return result;
    }
}
