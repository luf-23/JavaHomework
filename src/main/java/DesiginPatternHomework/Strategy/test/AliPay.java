package DesiginPatternHomework.Strategy.test;

public class AliPay implements PayStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("使用支付宝支付 " + amount + " 元");
    }
}
