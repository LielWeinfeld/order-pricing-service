package com.liel;
import java.util.List;

public class OrderPricingService {
    public double calculateTotal(List<OrderLine> lines) {
        if (lines == null || lines.isEmpty()) return 0.0;
        double subtotal = lines.stream()
                .mapToDouble(l -> l.qty() * l.price())
                .sum();
        double vat = subtotal * 0.17;
        return Math.round((subtotal + vat) * 100.0) / 100.0;
    }
}

record OrderLine(int qty, double price) {}
