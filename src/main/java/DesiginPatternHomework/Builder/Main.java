package DesiginPatternHomework.Builder;

public class Main {
    public static void main(String[] args) {
        // 构建 BMW 汽车
        CarBuilder bmwBuilder = new BMWCarBuilder();
        Director bmwDirector = new Director(bmwBuilder);
        Car bmw = bmwDirector.construct();
        System.out.println("【BMW 汽车】");
        bmw.show();

        System.out.println(); // 空行分隔

        // 构建 Benz 汽车
        CarBuilder benzBuilder = new BenzCarBuilder();
        Director benzDirector = new Director(benzBuilder);
        Car benz = benzDirector.construct();
        System.out.println("【Benz 汽车】");
        benz.show();
    }
}
