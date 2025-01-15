package org.converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();
        InputHandler inputHandler = new InputHandler(scanner);

        while (true) {
            System.out.println("Currency Converter App:");
            System.out.println("1. SEK to USD");
            System.out.println("2. USD to SEK");
            System.out.println("3. SEK to Euro");
            System.out.println("4. Euro to SEK");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = inputHandler.getMenuChoice();
            if (choice == 5) {
                break;
            }

            System.out.print("Enter amount: ");
            double amount = inputHandler.getAmount();

            double result = converter.convert(choice, amount);
            System.out.printf("Converted amount: %.2f\n", result);
        }
    }
}
