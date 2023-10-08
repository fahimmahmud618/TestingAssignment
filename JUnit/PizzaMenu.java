package com.company;

import java.util.ArrayList;
import java.util.List;

public class PizzaMenu {
    private List<Pizza> menu;

    public PizzaMenu() {
        menu = new ArrayList<>();
        // Add your pizza options to the menu here
        menu.add(new Pizza("Cheesy Pizza", 8.99));
        menu.add(new Pizza("Veggie Pizza", 7.99));
        menu.add(new Pizza("Mexican Pizza", 9.99));
    }

    public void displayMenu() {
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i).getName() + " - $" + menu.get(i).getPrice());
        }
    }

    public Pizza getPizza(int choice) {
        if (choice >= 1 && choice <= menu.size()) {
            return menu.get(choice - 1);
        } else {
            System.out.println("Invalid choice. Please select a valid pizza.");
            return null;
        }
    }
}
