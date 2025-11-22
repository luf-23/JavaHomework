package DesiginPatternHomework.Bridge;

public abstract class Coffee {
    //高层控制器必须持有implementor的引用
    protected CoffeeAdditives additives;//添加物

    public Coffee(CoffeeAdditives additives) {
        this.additives = additives;
    }

    // 抽象方法，由子类实现
    public abstract void makeCoffee();
}

