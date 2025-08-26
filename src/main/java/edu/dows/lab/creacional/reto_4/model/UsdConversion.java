package model;

public class UsdConversion implements ConversionStrategy {
    private final double rate;

    public UsdConversion(double rate) {
        this.rate = rate;
    }

    @Override
    public double convert(double amount) {
        return amount * rate;
    }
}
