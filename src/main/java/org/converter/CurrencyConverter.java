package org.converter;

import java.util.Scanner;

public class CurrencyConverter {
    public double convert(int choice, double amount) {
        switch (choice) {
            case 1: return amount * 0.11; // SEK to USD
            case 2: return amount * 9.0;  // USD to SEK
            case 3: return amount * 0.095; // SEK to Euro
            case 4: return amount * 10.5; // Euro to SEK
            default: return 0;
        }
    }
}