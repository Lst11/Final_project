package by.itacademy.finalProject.domain;

import by.itacademy.finalProject.json.ArrayIntDeserializer;
import by.itacademy.finalProject.service.menu.Menu;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Product implements Comparable<Product> {
    private static Logger LOGGER = Logger.getLogger(Product.class.getName());
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String name;
    private String description;
    private Date date;
    private Double price;
    private String group;
    @JsonDeserialize(using = ArrayIntDeserializer.class)
    private int[] marks;

    public Product() {
    }

    public Product(String name, String description, Date date, Double price, String group, int[] marks) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.price = price;
        this.group = group;
        this.marks = marks;
    }

    public Product(String name, String description, String dateInString, String price, String group, String marksInString) throws ParseException {
        this.name = name;
        this.description = description;
        this.date = dateFormat.parse(dateInString);
        this.price = Double.parseDouble(price);
        this.group = group;
        String[] numbersAsString = marksInString.split(",");
        int marks[] = new int[numbersAsString.length];
        for (int i = 0; i < marks.length; i++) {
            marks[i] = Integer.parseInt(numbersAsString[i]);
        }
        this.marks = marks;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }

    public static class ProductBuilder {
        private Product product = new Product();

        public ProductBuilder name(String name) {
            product.name = name;
            return this;
        }

        public ProductBuilder description(String description) {
            product.description = description;
            return this;
        }

        public ProductBuilder date(String dateInString) {
            try {
                product.date = dateFormat.parse(dateInString);
            } catch (ParseException e) {
                LOGGER.log(Level.INFO, e.getMessage());
            }
            return this;
        }

        public ProductBuilder price(double price) {
            product.price = price;
            return this;
        }

        public ProductBuilder group(String group) {
            product.group = group;
            return this;
        }

        public ProductBuilder marks(String marksInString) {
            String[] numbersAsString = marksInString.split(",");
            int marks[] = new int[numbersAsString.length];
            for (int i = 0; i < marks.length; i++) {
                marks[i] = Integer.parseInt(numbersAsString[i]);
            }
            product.marks = marks;
            return this;
        }

        public Product build() {
            return product;
        }
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public Double getPrice() {
        return price;
    }

    public String getGroup() {
        return group;
    }

    public int[] getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date=" + dateFormat.format(date) +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Product o) {
        return this.getName().toUpperCase().compareTo(o.getName().toUpperCase());
    }
}
