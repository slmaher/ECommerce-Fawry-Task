import java.time.LocalDate;
import model.*;
import service.Store;
import user.Customer;
//This file is used to ensure that the system accurately handles regular as well as edge cases, such as stock validation, expiration, shipping calculations, avaliablity, and payment processing
public class ECommerceApp {
    public static void main(String[] args) {
System.out.println("*********** ECommerce System For Fawry Task *********");


        // create a store instance and a Person with the initial balance
        Store store = new Store();
        Customer customer = new Customer("Salma", 500);

        // Initialize products with price,stock, and expiration details
        Cheese cheese = new Cheese("Cheese", 200, 5, LocalDate.now().plusDays(6), 0.3);
        Biscuits biscuits = new Biscuits("Biscuits", 150, 3, LocalDate.now().plusDays(10), 0.7);
        ScratchCard scratchCard = new ScratchCard("ScratchCard", 50, 10);
        Book book = new Book("Java Book", 120, 2);

        System.out.println("\n--- $Test 1: Successful checkout$ ---");
        try {
            customer.getCart().add(cheese, 4);
            customer.getCart().add(biscuits, 1);
            customer.getCart().add(scratchCard, 1);
            store.checkout(customer);
        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }

        System.out.println("\n--- $$Test 2: Expired product$$ ---");
        Cheese expiredCheese = new Cheese("Expired Cheese", 180, 2, LocalDate.now().minusDays(2), 0.3);
        try {
            customer.getCart().add(expiredCheese, 1);
        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }

        System.out.println("\n--- $$Test 3: Insufficient balance$$ ---");
        Customer poorCustomer = new Customer("Bob", 10);
        try {
            poorCustomer.getCart().add(biscuits, 1);
            store.checkout(poorCustomer);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- $$Test 4: Quantity exceeds stock$$ ---");
        try {
            customer.getCart().add(book, 15); // Only 2 available in stock
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

        System.out.println("\n--- $$Test 5: Checkout with empty cart$$ ---");
        try {
            Customer emptyCartCustomer = new Customer("Maher", 300);
            store.checkout(emptyCartCustomer);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
