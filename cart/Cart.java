package cart;

import java.util.*;
import model.ExpirableProduct;
import model.Product;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void add(Product product, int quantity) {
        if (product instanceof ExpirableProduct) {
            ExpirableProduct exp = (ExpirableProduct) product;
            if (exp.isExpired()) {
                throw new IllegalArgumentException("Product is expired");
            }
        }
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Product is out of stock");
        }
        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                throw new IllegalArgumentException("Product already in cart");
            }
        }
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }
} 