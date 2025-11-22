package DesiginPatternHomework.Strategy.test;

public class ShoppingCart {
    private PayStrategy payStrategy;

    public void setPayStrategy(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    //结算
    public void checkout(double amount) {
        payStrategy.pay(amount);
    }
}
