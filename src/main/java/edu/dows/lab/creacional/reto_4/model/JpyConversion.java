package model;

public class JpyConversion implements ConversionStrategy {
    private final double rate;

    public JpyConversion(double rate) {
        this.rate = rate;
    }

    @Override
    public double convert(double amount) {
        return amount * rate;
    }
}