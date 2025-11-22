package DesiginPatternHomework.Strategy.test;

public class CreditCardPay implements PayStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("使用信用卡支付：" + amount);
    }
}
