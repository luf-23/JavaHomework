package DesiginPatternHomework.Bridge;

public class MediumCoffee extends Coffee {
    public MediumCoffee(CoffeeAdditives additives) {
        super(additives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("中杯咖啡 " + additives.add());
    }
}
