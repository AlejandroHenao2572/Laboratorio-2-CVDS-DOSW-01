package edu.dows.lab.creacional.reto_4;

import edu.dows.lab.creacional.reto_4.model.Currency;
import edu.dows.lab.creacional.reto_4.service.CurrencyConverter;

import java.util.*;

public class CasaDeCambio {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        Map<Currency, Double> rates = new HashMap<>();
        rates.put(Currency.USD, 1.0);
        rates.put(Currency.EUR, 0.92);
        rates.put(Currency.JPY, 155.0);
        rates.put(Currency.COP, 4000.0);

        Map<Currency, Double> totals = new HashMap<>();

        System.out.print("Ingrese número de transacciones: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Transacción " + (i + 1) + " ---");
            System.out.print("Ingrese monto: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Ingrese moneda de origen (USD, EUR, JPY, COP): ");
            Currency origin = Currency.valueOf(scanner.nextLine().trim().toUpperCase());
            System.out.print("Ingrese monedas destino (separadas por coma, ej: USD,JPY): ");
            String[] dests = scanner.nextLine().split(",");

            System.out.printf("Transacción %d: %.0f %s\n", i + 1, amount, origin);

            for (String destStr : dests) {
                Currency dest = Currency.valueOf(destStr.trim().toUpperCase());
                if (origin == dest) continue;
                // Convertir primero a USD si no es USD
                double amountInUSD = (origin == Currency.USD) ? amount : amount / rates.get(origin);
                // Luego de USD a destino
                double converted = (dest == Currency.USD) ? amountInUSD : amountInUSD * rates.get(dest);

                totals.put(dest, totals.getOrDefault(dest, 0.0) + converted);

                System.out.printf("Convertido a %s: %.3f %s\n", dest, converted, dest);
            }
        }

        System.out.println("\n--- Totales por moneda ---");
        for (Currency c : totals.keySet()) {
            System.out.printf("%s: %.3f %s\n", c, totals.get(c), c);
        }
    }
    public static void main(String[] args) {
        run();
    }
}