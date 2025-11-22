package DesiginPatternHomework.Strategy.test;

public class CashPay implements PayStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("使用现金支付，支付金额：" + amount);
    }
}
