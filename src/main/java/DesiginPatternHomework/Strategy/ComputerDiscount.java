package DesiginPatternHomework.Strategy;

public class ComputerDiscount implements DiscountStrategy {
    private static final double RATE = 0.7;

    @Override
    public double calculate(double originalPrice) {
        return originalPrice * RATE;
    }
}
