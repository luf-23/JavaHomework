package DesiginPatternHomework.Strategy.test;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.setPayStrategy(new AliPay());//避免了一堆if-else判断语句,且每个策略可单独测试
        cart.checkout(100);
    }
}
