package DesiginPatternHomework.Builder;

public class BMWCarBuilder extends CarBuilder {
    @Override
    public void buildWheel() {
        car.setWheel("BMW 高性能合金轮毂");
    }

    @Override
    public void buildOilBox() {
        car.setOilBox("BMW 高效燃油箱 (70L)");
    }

    @Override
    public void buildBody() {
        car.setBody("BMW 流线型碳纤维车身");
    }
}