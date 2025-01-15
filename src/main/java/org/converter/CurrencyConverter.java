package org.converter;

import java.io.IOException;

public class CurrencyConverter {
    private final ExchangeRateFetcher rateFetcher;

    public CurrencyConverter() {
        this.rateFetcher = new ExchangeRateFetcher();
    }

    public double convert(int choice, double amount) {
        try {
            return switch (choice) {
                case 1 -> amount * rateFetcher.getExchangeRate("USD"); // SEK to USD
                case 2 -> amount / rateFetcher.getExchangeRate("USD"); // USD to SEK
                case 3 -> amount * rateFetcher.getExchangeRate("EUR"); // SEK to Euro
                case 4 -> amount / rateFetcher.getExchangeRate("EUR"); // Euro to SEK
                default -> 0;
            };
        } catch (IOException e) {
            System.out.println("Failed to fetch current exchange rates. Using fallback rates.");
            return switch (choice) {
                case 1 -> amount * 0.11; // Fallback SEK to USD
                case 2 -> amount * 9.0;  // Fallback USD to SEK
                case 3 -> amount * 0.095; // Fallback SEK to Euro
                case 4 -> amount * 10.5; // Fallback Euro to SEK
                default -> 0;
            };
        }
    }
}