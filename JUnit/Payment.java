package com.company;

public class Payment {
    private User user;
    private double amount;
    private String paymentMethod;
    private int pin;

    public Payment(User user, double amount, String paymentMethod, int pin) {
        this.user = user;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.pin = pin;
    }

    public boolean processPayment() {
        if (user.getWallet() >= amount && isValidPIN()) {
            user.getCart().clear(); // Clear the user's cart after successful payment.
            user.setWallet(user.getWallet() - amount); // Deduct the amount from the user's wallet.
            return true;
        }
        return false;
    }

    public boolean isValidPIN() {
        // Replace this logic with your PIN validation logic.
        // For demonstration purposes, we assume any PIN is valid.
        return pin >= 1000 && pin <= 9999;
    }
}
