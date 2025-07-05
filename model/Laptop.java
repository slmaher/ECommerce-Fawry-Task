package model;

public class Laptop extends Product implements Shippable {
    private double weight; // in kg

    public Laptop(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
} 