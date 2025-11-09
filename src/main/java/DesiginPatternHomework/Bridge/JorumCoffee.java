package DesiginPatternHomework.Bridge;

public class JorumCoffee extends Coffee {
    public JorumCoffee(CoffeeAdditives additives) {
        super(additives);
    }

    @Override
    public void makeCoffee() {
        System.out.println("大杯咖啡 " + additives.add());
    }
}