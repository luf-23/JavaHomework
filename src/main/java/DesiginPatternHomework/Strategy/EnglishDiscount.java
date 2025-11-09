package DesiginPatternHomework.Strategy;

public class EnglishDiscount implements DiscountStrategy {
    private static final double RATE = 0.6;

    @Override
    public double calculate(double originalPrice) {
        return originalPrice * RATE;
    }
}