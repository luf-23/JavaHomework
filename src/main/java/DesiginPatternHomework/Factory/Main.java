package DesiginPatternHomework.Factory;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== OEM制造商笔记本工厂模式演示 ===\n");

        // 模拟OEM制造商接收不同品牌的订单
        String[] brands = {"HP", "Acer", "Lenovo", "Dell"};
        String[] models = {"Pavilion 15", "Aspire 5", "ThinkPad X1", "XPS 15"};

        // 生产不同品牌的笔记本
        Laptop[] laptops = new Laptop[brands.length];

        for (int i = 0; i < brands.length; i++) {
            System.out.println("正在生产 " + brands[i] + " " + models[i] + "...");
            laptops[i] = LaptopFactory.createLaptop(brands[i], models[i]);
            System.out.println("生产完成！\n");
        }

        // 测试所有笔记本的功能
        System.out.println("=== 测试所有笔记本功能 ===\n");

        for (Laptop laptop : laptops) {
            System.out.println("--- " + laptop.getBrand() + " " + laptop.getModel() + " ---");
            laptop.displaySpecs();
            laptop.start();
            laptop.shutdown();
            System.out.println();
        }

        // 演示添加新品牌（扩展性）
        System.out.println("=== 演示扩展性 - 尝试添加新品牌 ===");
        try {
            Laptop newBrandLaptop = LaptopFactory.createLaptop("Apple", "MacBook Pro");
        } catch (IllegalArgumentException e) {
            System.out.println("错误: " + e.getMessage());
            System.out.println("要支持新品牌，只需添加新的具体产品类并更新工厂方法即可！\n");
        }

        // 演示工厂模式的优势
        System.out.println("=== 工厂模式优势 ===");
        System.out.println("1. 客户端代码与具体产品解耦");
        System.out.println("2. 易于扩展新品牌 - 开闭原则");
        System.out.println("3. 集中管理对象创建逻辑");
        System.out.println("4. 代码更清晰、更易维护");
    }
}