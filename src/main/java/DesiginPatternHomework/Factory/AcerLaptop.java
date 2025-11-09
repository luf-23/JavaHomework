package DesiginPatternHomework.Factory;

public class AcerLaptop implements Laptop {
    private final String model;

    public AcerLaptop(String model) {
        this.model = model;
    }

    @Override
    public String getBrand() {
        return "Acer";
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public void start() {
        System.out.println(getBrand() + " " + getModel() + " 正在启动...");
    }

    @Override
    public void shutdown() {
        System.out.println(getBrand() + " " + getModel() + " 正在关机...");
    }

    @Override
    public void displaySpecs() {
        System.out.println("品牌: " + getBrand());
        System.out.println("型号: " + getModel());
        System.out.println("处理器: AMD Ryzen 5");
        System.out.println("内存: 8GB DDR4");
        System.out.println("存储: 256GB SSD");
        System.out.println("屏幕: 14英寸 HD");
    }
}