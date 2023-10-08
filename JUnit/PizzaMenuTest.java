package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class PizzaMenuTest {
    private PizzaMenu pizzaMenu;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        pizzaMenu = new PizzaMenu();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testDisplayMenu() {
        pizzaMenu.displayMenu();
        String expectedOutput = "1. Cheesy Pizza - $8.99\n2. Veggie Pizza - $7.99\n3. Mexican Pizza - $9.99\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testGetValidPizza() {
        Pizza pizza = pizzaMenu.getPizza(1);
        assertNotNull(pizza);
        assertEquals("Cheesy Pizza", pizza.getName());
    }

    @Test
    public void testGetInvalidPizza() {
        Pizza pizza = pizzaMenu.getPizza(5);
        assertNull(pizza);
    }
}

