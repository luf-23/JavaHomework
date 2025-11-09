package DesiginPatternHomework.Builder;

public class BenzCarBuilder extends CarBuilder {
    @Override
    public void buildWheel() {
        car.setWheel("Benz 豪华镀铬轮毂");
    }

    @Override
    public void buildOilBox() {
        car.setOilBox("Benz 耐用油箱 (75L)");
    }

    @Override
    public void buildBody() {
        car.setBody("Benz 经典金属漆车身");
    }
}