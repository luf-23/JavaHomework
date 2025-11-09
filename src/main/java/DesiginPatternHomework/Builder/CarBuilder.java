package DesiginPatternHomework.Builder;

// CarBuilder.java - 抽象建造者
public abstract class CarBuilder {
    protected Car car = new Car();

    public abstract void buildWheel();
    public abstract void buildOilBox();
    public abstract void buildBody();

    public Car getResult() {
        return car;
    }
}