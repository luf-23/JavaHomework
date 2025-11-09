package DesiginPatternHomework.AbstractFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 抽象工厂模式演示 - 快餐店产品系列 ===\n");

        // 创建麦当劳订单
        System.out.println("客户1想要麦当劳套餐：");
        AbstractFastFoodFactory mcDonaldsFactory = new McDonaldsFactory();
        FastFoodOrder mcDonaldsOrder = new FastFoodOrder(mcDonaldsFactory);
        mcDonaldsOrder.placeOrder();

        // 创建肯德基订单
        System.out.println("客户2想要肯德基套餐：");
        AbstractFastFoodFactory kfcFactory = new KFCFactory();
        FastFoodOrder kfcOrder = new FastFoodOrder(kfcFactory);
        kfcOrder.placeOrder();

        // 演示产品族的一致性
        System.out.println("=== 产品族一致性演示 ===");
        System.out.println("通过抽象工厂确保：");
        System.out.println("- 麦当劳订单只能包含麦当劳的汉堡和可乐");
        System.out.println("- 肯德基订单只能包含肯德基的汉堡和可乐");
        System.out.println("- 不会出现麦当劳汉堡配肯德基可乐的混合订单\n");

        // 演示扩展性
        System.out.println("=== 扩展性演示 ===");
        System.out.println("如果要添加新的快餐品牌（如汉堡王）：");
        System.out.println("1. 创建新的具体产品类（BurgerKingHamburg, BurgerKingCola）");
        System.out.println("2. 创建新的具体工厂类（BurgerKingFactory）");
        System.out.println("3. 客户端代码无需修改，只需使用新的工厂即可");
        System.out.println("这体现了开闭原则：对扩展开放，对修改关闭");
    }
}