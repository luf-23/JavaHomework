package DesiginPatternHomework.Strategy;

public class NovelDiscount implements DiscountStrategy {
    private static final double RATE = 0.8;

    @Override
    public double calculate(double originalPrice) {
        return originalPrice * RATE;
    }
}