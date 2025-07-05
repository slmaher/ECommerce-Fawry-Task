package service;

import cart.Cart;
import cart.CartItem;
import model.Product;
import model.Shippable;
import user.Customer;
import java.util.*;

public class Store {
    public void checkout(Customer customer) {
        Cart cart = customer.getCart();
        if (cart.isEmpty()) {
            throw new IllegalArgumentException("Cart is empty");
        }
        List<CartItem> items = cart.getItems();
        List<Shippable> shippables = new ArrayList<>();
        List<Integer> shipQuantities = new ArrayList<>();
        double subtotal = 0.0;
        for (CartItem item : items) {
            Product p = item.getProduct();
            int qty = item.getQuantity();
            subtotal += p.getPrice() * qty;
            if (p instanceof Shippable) {
                shippables.add((Shippable) p);
                shipQuantities.add(qty);
            }
        }
        double totalWeight = 0.0;
        if (!shippables.isEmpty()) {
            totalWeight = ShippingService.printShipmentNotice(shippables, shipQuantities);
        }
        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            System.out.printf("%dx %s     %.0f\n", item.getQuantity(), item.getProduct().getName(), item.getProduct().getPrice());
        }
        System.out.println("---------------------");
        System.out.printf("Subtotal       %.0f\n", subtotal);
        double shipping = totalWeight * 5.0;
        if (shipping > 0) {
            System.out.printf("Shipping        %.0f\n", shipping);
        }
        double amount = subtotal + shipping;
        System.out.printf("Amount          %.0f\n", amount);
        if (amount > customer.getBalance()) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        customer.deduct(amount);
        for (CartItem item : items) {
            Product p = item.getProduct();
            p.setQuantity(p.getQuantity() - item.getQuantity());
        }
        System.out.printf("Remaining balance %.0f\n\n", customer.getBalance());
        cart.clear();
    }
} 