package edu.dows.lab.creacional.reto_4.service;

import edu.dows.lab.creacional.reto_4.model.ConversionStrategy;

public class CurrencyConverter {
    private ConversionStrategy strategy;

    public void setStrategy(ConversionStrategy strategy) {
        this.strategy = strategy;
    }

    public double convert(double amount) {
        if (strategy == null) throw new IllegalStateException("No strategy set");
        return strategy.convert(amount);
    }
}
