package model;

public class CopConversion implements ConversionStrategy {
    private final double rate;

    public CopConversion(double rate) {
        this.rate = rate;
    }

    @Override
    public double convert(double amount) {
        return amount * rate;
    }
}