package com.liel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

class OrderPricingServiceTest {
    OrderPricingService s = new OrderPricingService();

    @Test void emptyListReturnsZero() {
        assertEquals(0.0, s.calculateTotal(List.of()));
    }

    @Test void singleItem() {
        assertEquals(117.0, s.calculateTotal(List.of(new OrderLine(1, 100))));
    }

    @Test void multipleItems() {
        assertEquals(234.0, s.calculateTotal(List.of(
            new OrderLine(1, 100),
            new OrderLine(1, 100)
        )));
    }

    @Test void roundingCheck() {
        assertEquals(117.59, s.calculateTotal(List.of(new OrderLine(1, 100.5))));
    }

    @Test void nullListReturnsZero() {
        assertEquals(0.0, s.calculateTotal(null));
    }

    @Test void zeroQuantity() {
        assertEquals(0.0, s.calculateTotal(List.of(new OrderLine(0, 100))));
    }

    @Test void largeNumbers() {
        assertEquals(117000.0, s.calculateTotal(List.of(new OrderLine(1000, 100))));
    }
}