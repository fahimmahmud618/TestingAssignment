package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;
    private PizzaMenu menu;

    @BeforeEach
    public void setUp() {
        user = new User("TestUser", 20.0);
        menu = new PizzaMenu();
    }

    @Test
    public void testAddToCart() {
        Pizza pizza = menu.getPizza(1); // Get the first pizza from the menu
        user.addToCart(pizza, 2);
        assertEquals(2, user.getCart().size());
    }

    @Test
    public void testRemoveFromCart() {
        Pizza pizza = menu.getPizza(1);
        user.addToCart(pizza, 3);
        user.removeFromCart(pizza, 1);
        assertEquals(2, user.getCart().size());
    }

    @Test
    public void testCalculateTotalBill() {
        Pizza pizza1 = menu.getPizza(1);
        Pizza pizza2 = menu.getPizza(2);
        user.addToCart(pizza1, 2);
        user.addToCart(pizza2, 1);
        assertEquals(25.97, user.calculateTotalBill(), 0.01);
    }

    @Test
    public void testMakePaymentSufficientFunds() {
        Pizza pizza = menu.getPizza(3); // Get the third pizza from the menu
        user.addToCart(pizza, 1);
        assertTrue(user.makePayment("bkash", 1234));
    }

    @Test
    public void testMakePaymentInsufficientFunds() {
        Pizza pizza = menu.getPizza(2);
        user.addToCart(pizza, 4);
        assertFalse(user.makePayment("nagad", 5678));
    }
}

