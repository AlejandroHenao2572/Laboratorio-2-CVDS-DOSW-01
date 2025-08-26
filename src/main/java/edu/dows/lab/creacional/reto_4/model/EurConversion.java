package model;

public class EurConversion implements ConversionStrategy {
    private final double rate;

    public EurConversion(double rate) {
        this.rate = rate;
    }

    @Override
    public double convert(double amount) {
        return amount * rate;
    }
}
