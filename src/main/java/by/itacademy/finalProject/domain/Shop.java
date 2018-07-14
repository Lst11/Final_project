package by.itacademy.finalProject.domain;

import by.itacademy.finalProject.service.сomparators.NameComparator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Shop {
    private String name;
    private String location;
    @JsonProperty("emails")
    private Set<String> emails = new HashSet<>();
    @JsonDeserialize(as = TreeSet.class)
    private Set<Product> goods = new TreeSet<>(new NameComparator());

    public Shop() {
    }

    public Shop(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public static ShopBuilder builder() {
        return new ShopBuilder();
    }

    public static class ShopBuilder {
        private Shop shop = new Shop();

        public ShopBuilder name(String name) {
            shop.name = name;
            return this;
        }

        public ShopBuilder location(String location) {
            shop.location = location;
            return this;
        }

        public ShopBuilder email(String email) {
            shop.emails.add(email);
            return this;
        }

        public ShopBuilder add(Product product) {
            shop.add(product);
            return this;
        }

        public Shop build() {
            return shop;
        }
    }


    public void add(Product product) {
        goods.remove(product);
        goods.add(product);
    }

    public void addAll(Set<Product> goods) {
        this.goods.removeAll(goods);
        this.goods.addAll(goods);
    }

    public Set<Product> getGoods() {
        return goods;
    }

    @Override
    public String toString() {
        return "Shop{" + "\n" +
                "name: " + name + "\n" +
                "location: " + location + "\n" +
                "emails: " + emails + "\n" +
                "goods: \n" + goods +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Set<String> getEmail() {
        return emails;
    }
}
