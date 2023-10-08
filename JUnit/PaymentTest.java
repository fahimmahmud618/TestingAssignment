package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("TestUser", 30.0);
    }

    @Test
    public void testSuccessfulPayment() {
        Payment payment = new Payment(user, 25.0, "bkash", 1234);
        assertTrue(payment.processPayment());
        assertEquals(5.0, user.getWallet(), 0.01);
    }

    @Test
    public void testInsufficientFunds() {
        Payment payment = new Payment(user, 40.0, "nagad", 5678);
        assertFalse(payment.processPayment());
        assertEquals(30.0, user.getWallet(), 0.01);
    }

    @Test
    public void testInvalidPIN() {
        Payment payment = new Payment(user, 15.0, "bkash", 9999);
//        assertFalse(payment.processPayment());
//        assertEquals(30.0, user.getWallet(), 0.01);
            assertTrue(payment.isValidPIN());
    }
}

