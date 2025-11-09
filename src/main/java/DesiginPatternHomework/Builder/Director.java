package DesiginPatternHomework.Builder;

public class Director {
    private CarBuilder builder;

    public Director(CarBuilder builder) {
        this.builder = builder;
    }

    public Car construct() {
        builder.buildWheel();
        builder.buildOilBox();
        builder.buildBody();
        return builder.getResult();
    }
}
