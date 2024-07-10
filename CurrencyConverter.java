package switchstatement;

import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {

    // Method to convert currency
    public static double convert(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define exchange rates for different currencies relative to USD
        HashMap<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("INRtoUSD", 0.012);
        exchangeRates.put("USDtoINR", 82.73);
        exchangeRates.put("EURtoUSD", 1.1);
        exchangeRates.put("USDtoEUR", 0.91);
        // Add more currency pairs and their exchange rates as needed

        // Getting the currency types from the user
        System.out.print("Enter the source currency code (e.g., INR, USD, EUR): ");
        String sourceCurrency = scanner.next().toUpperCase();
        System.out.print("Enter the target currency code (e.g., USD, INR, EUR): ");
        String targetCurrency = scanner.next().toUpperCase();
        String key = sourceCurrency + "to" + targetCurrency;

        // Check if the currency pair exists in the map
        if (!exchangeRates.containsKey(key)) {
            System.out.println("Currency pair not supported.");
            return;
        }

        // Getting the amount to convert from the user
        System.out.print("Enter the amount in " + sourceCurrency + ": ");
        double amount = scanner.nextDouble();

        // Performing the conversion
        double exchangeRate = exchangeRates.get(key);
        double convertedAmount = convert(amount, exchangeRate);

        // Displaying the converted amount
        System.out.printf("The converted amount is: %.2f %s%n", convertedAmount, targetCurrency);

        // Closing the scanner
        scanner.close();
    }
}
