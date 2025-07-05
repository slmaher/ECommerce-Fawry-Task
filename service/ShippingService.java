package service;

import java.util.List;
import model.Shippable;

public class ShippingService {
    public static double printShipmentNotice(List<Shippable> shippables, List<Integer> quantities) {
        System.out.println("*******Shipment_notice********");
        double totalWeight = 0.0;
        for (int i = 0; i < shippables.size(); i++) {
            Shippable s = shippables.get(i);
            int qty = quantities.get(i);
            double weight = s.getWeight() * qty;
            totalWeight += weight;
            System.out.printf("%dx %s     %.0fg\n", qty, s.getName(), weight * 1000);
        }
        System.out.printf("total weight for package t %.1fkg\n\n", totalWeight);
        return totalWeight;
    }
} 