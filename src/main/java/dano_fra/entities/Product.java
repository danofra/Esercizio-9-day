package dano_fra.entities;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Product {
    private final Long id;
    private final String name;
    public String category;
    Random random = new Random();
    private double price;

    public Product(String name, String category, double price) {
        this.id = random.nextLong(1, 1000000000);
        this.name = name;
        this.category = category;
        this.price = price;
    }
    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Product: " +
                "Name:" + name +
                ", Category: " + category+
                ", Price: " + price;
    }
}
