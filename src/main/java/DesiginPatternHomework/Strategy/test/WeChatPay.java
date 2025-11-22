package DesiginPatternHomework.Strategy.test;

public class WeChatPay implements PayStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("使用微信支付：" + amount);
    }
}
