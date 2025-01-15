// Main.java
package org.converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();
        InputHandler inputHandler = new InputHandler(scanner);

        while (true) {
            // Display the menu with ASCII art and colors
            ConsoleStyler.printColored(ConsoleStyler.Color.BLUE, "╔════════════════════════════════╗");
            ConsoleStyler.printColored(ConsoleStyler.Color.BLUE, "║        Currency Converter      ║");
            ConsoleStyler.printColored(ConsoleStyler.Color.BLUE, "╚════════════════════════════════╝");

            String[] options = {
                    "1. SEK to USD",
                    "2. USD to SEK",
                    "3. SEK to Euro",
                    "4. Euro to SEK",
                    "5. Exit"
            };

            for (String option : options) {
                ConsoleStyler.printColored(ConsoleStyler.Color.GREEN, option);
            }

            System.out.print("Enter your choice: ");
            int choice = inputHandler.getMenuChoice();

            if (choice == 5) {
                ConsoleStyler.printColored(ConsoleStyler.Color.YELLOW, "Exiting the application. Goodbye!");
                break;
            }

            System.out.print("Enter amount: ");
            double amount = inputHandler.getAmount();

            double result = converter.convert(choice, amount);
            ConsoleStyler.printColored(ConsoleStyler.Color.YELLOW, String.format("Converted amount: %.2f", result));
        }
    }
}
