package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PizzaTest {

    @Test
    public void testPizzaName() {
        Pizza pizza = new Pizza("Cheese Pizza", 9.99);
        assertEquals("Cheese Pizza", pizza.getName());
    }

    @Test
    public void testPizzaPrice() {
        Pizza pizza = new Pizza("Veggie Pizza", 8.49);
        assertEquals(8.49, pizza.getPrice(), 0.01);
    }

    @Test
    public void testNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Pizza("Invalid Pizza", -5.0);
        });
    }
}

