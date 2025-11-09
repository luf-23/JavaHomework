package DesiginPatternHomework.Bridge;

public abstract class Coffee {
    protected CoffeeAdditives additives;

    public Coffee(CoffeeAdditives additives) {
        this.additives = additives;
    }

    // 抽象方法，由子类实现
    public abstract void makeCoffee();
}

