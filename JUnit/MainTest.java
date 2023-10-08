package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testPizzaOrderingAndPayment() {
        // Simulate user input for testing purposes
        String input = "TestUser\n50\n1\n2\n-1\nbkash\n1234\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        // Redirect System.out to capture printed output
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        // Run the main method
        Main.main(new String[]{});

        // Assert that the correct output is printed
        String expectedOutput = "Enter your name:\n Enter your wallet balance: $\nPizza Menu:\n" +
                "1. Cheesy Pizza - $8.99\n" +
                "2. Veggie Pizza - $7.99\n" +
                "3. Mexican Pizza - $9.99\n" +
                "Enter the number of the pizza you want to order (or -1 to checkout):\n" +
                "Enter the quantity: Enter the number of the pizza you want to order (or -1 to checkout):\n" +
                "Enter the quantity: Your Cart:\n" +
                "- Cheesy Pizza\n" +
                "- Veggie Pizza\n" +
                "Total Bill: $16.98\n" +
                "Select a payment method (bkash or nagad): Enter your PIN: Payment successful!\n" +
                "Invoice:\n" +
                "Total Amount: $16.98\n" +
                "Payment Method: bkash\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}

