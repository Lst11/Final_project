package by.itacademy.finalProject.service;

import by.itacademy.finalProject.domain.Product;
import by.itacademy.finalProject.domain.Shop;
import by.itacademy.finalProject.service.out.PrintResultOfTheOperation;

import java.util.ArrayList;
import java.util.List;

public class SearchForSimilarProduct implements Operation {
    private List<Product> result = new ArrayList<>();

    @Override
    public void execute(Shop shop) {
        result = new ArrayList<>();
        SearchGoodsByName search = new SearchGoodsByName();
        search.execute(shop);
        Product productForSearch = search.getResult();
        findProductsByGroup(shop, productForSearch);
        new PrintResultOfTheOperation().execute(result);
    }

    public void findProductsByGroup(Shop shop, Product productForSearch) {
        for (Product product : shop.getGoods()) {
            if (product.getGroup().equals(productForSearch.getGroup()) && !(product.getName().equalsIgnoreCase(productForSearch.getName()))) {
                result.add(product);
            }
        }
    }

    public List<Product> getResult() {
        return result;
    }
}
