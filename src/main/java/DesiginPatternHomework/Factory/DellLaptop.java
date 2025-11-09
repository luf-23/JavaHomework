package DesiginPatternHomework.Factory;

public class DellLaptop implements Laptop {
    private final String model;

    public DellLaptop(String model) {
        this.model = model;
    }

    @Override
    public String getBrand() {
        return "Dell";
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
        System.out.println("处理器: Intel Core i9");
        System.out.println("内存: 32GB DDR4");
        System.out.println("存储: 2TB SSD");
        System.out.println("屏幕: 17.3英寸 UHD");
    }
}