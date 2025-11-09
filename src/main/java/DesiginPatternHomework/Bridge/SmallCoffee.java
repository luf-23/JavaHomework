package DesiginPatternHomework.Bridge;

public class SmallCoffee extends Coffee {
    public SmallCoffee(CoffeeAdditives additives) {
        super(additives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("小杯咖啡 " + additives.add());
    }
}