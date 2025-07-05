package model;

public class TV extends Product implements Shippable {
    private double weight; // in kg

    public TV(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
} 