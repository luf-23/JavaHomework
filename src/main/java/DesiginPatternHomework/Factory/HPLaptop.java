package DesiginPatternHomework.Factory;

public class HPLaptop implements Laptop {
    private final String model;

    public HPLaptop(String model) {
        this.model = model;
    }

    @Override
    public String getBrand() {
        return "HP";
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
        System.out.println("处理器: Intel Core i7");
        System.out.println("内存: 16GB DDR4");
        System.out.println("存储: 512GB SSD");
        System.out.println("屏幕: 15.6英寸 FHD");
    }
}