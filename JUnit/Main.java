package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter your wallet balance: $");
        double userWallet = scanner.nextDouble();
        User user = new User(userName, userWallet);

        PizzaMenu menu = new PizzaMenu();
        int choice;
        do {
            System.out.println("\nPizza Menu:");
            menu.displayMenu();
            System.out.println("Enter the number of the pizza you want to order (or -1 to checkout):");
            choice = scanner.nextInt();
            if (choice != -1) {
                System.out.print("Enter the quantity: ");
                int quantity = scanner.nextInt();

                Pizza selectedPizza = menu.getPizza(choice);
                user.addToCart(selectedPizza, quantity);
            }

        } while (choice != -1);

        user.displayCart();

        System.out.print("\nSelect a payment method (bkash or nagad): ");
        String paymentMethod = scanner.next();
        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();

        if (user.makePayment(paymentMethod, pin)) {
            System.out.println("Payment successful!");
            System.out.println("Invoice:");
            System.out.println("Total Amount: $" + user.calculateTotalBill());
            System.out.println("Payment Method: " + paymentMethod);
        } else {
            System.out.println("Payment failed. Insufficient funds or invalid PIN.");
        }
    }

}

