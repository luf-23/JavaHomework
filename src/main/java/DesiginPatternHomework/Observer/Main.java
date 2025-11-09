package DesiginPatternHomework.Observer;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== 网上商店观察者模式演示 ==========\n");

        // 创建商品
        Product phone = new Product("iPhone 16", 7999.0);
        System.out.println("✅ 创建商品：" + phone);

        // 创建会员
        Member alice = new Member("Alice");
        Member bob = new Member("Bob");
        Member charlie = new Member("Charlie");

        // 订阅通知
        phone.registerObserver(alice);
        phone.registerObserver(bob);

        System.out.println();

        // 修改商品信息 → 自动通知
        phone.setPrice(7499.0);  // 降价促销

        System.out.println();

        phone.setName("iPhone 16 Pro"); // 升级版

        System.out.println();

        // 新会员订阅
        phone.registerObserver(charlie);

        System.out.println();

        phone.setPrice(8999.0);  // Pro 版涨价

        System.out.println("\n========== 演示结束 ==========");
    }
}
