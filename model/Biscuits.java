package model;

import java.time.LocalDate;

public class Biscuits extends ExpirableProduct implements Shippable {
    private double weight; // in kg

    public Biscuits(String name, double price, int quantity, LocalDate expirationDate, double weight) {
        super(name, price, quantity, expirationDate);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
} 