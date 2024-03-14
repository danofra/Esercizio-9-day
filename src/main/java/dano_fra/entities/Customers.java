package dano_fra.entities;

import java.util.Random;
public class Customers {
    private Long id;
    private final String name;
    private int tier;

    Random random = new Random();

    public Customers(String name, int tier) {
        this.id = random.nextLong(1,1000000000);
        this.name = name;
        this.tier = tier;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customers: " +
                "Name: " + name +
                ", Tier: " + tier;
    }
}
