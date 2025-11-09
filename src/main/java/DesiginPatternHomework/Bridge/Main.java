package DesiginPatternHomework.Bridge;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 咖啡店菜单 ===");

        // 创建不同组合
        Coffee smallWithMilk = new SmallCoffee(new Milk());
        Coffee mediumWithSugar = new MediumCoffee(new Sugar());
        Coffee jorumWithLemon = new JorumCoffee(new Lemon());
        Coffee smallWithSugar = new SmallCoffee(new Sugar());
        Coffee mediumWithMilk = new MediumCoffee(new Milk());
        Coffee jorumWithSugar = new JorumCoffee(new Sugar());

        // 制作咖啡
        smallWithMilk.makeCoffee();
        mediumWithSugar.makeCoffee();
        jorumWithLemon.makeCoffee();
        smallWithSugar.makeCoffee();
        mediumWithMilk.makeCoffee();
        jorumWithSugar.makeCoffee();

        System.out.println("\n=== 所有组合示例 ===");
        // 演示所有可能的组合
        CoffeeAdditives[] additives = {new Milk(), new Sugar(), new Lemon()};
        String[] sizes = {"小杯", "中杯", "大杯"};

        for (int i = 0; i < sizes.length; i++) {
            for (CoffeeAdditives additive : additives) {
                Coffee coffee;
                switch (i) {
                    case 0:
                        coffee = new SmallCoffee(additive);
                        break;
                    case 1:
                        coffee = new MediumCoffee(additive);
                        break;
                    case 2:
                        coffee = new JorumCoffee(additive);
                        break;
                    default:
                        coffee = new SmallCoffee(additive);
                }
                coffee.makeCoffee();
            }
        }
    }
}
