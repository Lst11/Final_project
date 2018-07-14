package by.itacademy.finalProject.service;

import by.itacademy.finalProject.domain.Product;
import by.itacademy.finalProject.domain.Shop;
import by.itacademy.finalProject.service.out.PrintSet;
import by.itacademy.finalProject.service.сomparators.PriceComparator;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortGoodsByPrice implements Operation {
    private Set<Product> sortedGoods = new TreeSet<>(new PriceComparator());

    @Override
    public void execute(Shop shop) {
        sortedGoods.addAll(shop.getGoods());
        new PrintSet().execute(sortedGoods);
    }

    public List<Product> getResult() {
        return new LinkedList<>(sortedGoods);
    }
}
