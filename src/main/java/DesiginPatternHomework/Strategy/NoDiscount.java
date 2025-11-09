package DesiginPatternHomework.Strategy;

public class NoDiscount implements DiscountStrategy {
    @Override
    public double calculate(double originalPrice) {
        return originalPrice; // 无折扣
    }
}