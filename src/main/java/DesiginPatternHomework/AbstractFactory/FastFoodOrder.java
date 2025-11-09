package DesiginPatternHomework.AbstractFactory;

public class FastFoodOrder {
    private final Hamburger hamburger;
    private final Cola cola;
    private final String storeName;


    public FastFoodOrder(AbstractFastFoodFactory factory) {
        this.storeName = factory.getStoreName();
        this.hamburger = factory.createHamburger();
        this.cola = factory.createCola();
    }


    public void placeOrder() {
        System.out.println("=== " + storeName + " 订单 ===");
        System.out.println("正在处理您的订单...");

        // 制作汉堡
        hamburger.make();

        // 倒可乐
        cola.pour();

        System.out.println("\n订单完成！您的餐品：");
        System.out.println("- " + hamburger.getDescription());
        System.out.println("- " + cola.getDescription());
        System.out.println("========================\n");
    }
}