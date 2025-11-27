package DesiginPatternHomework.State;

import java.util.Scanner;

/**
 * 状态模式演示 - 自动售货机
 * 
 * 状态模式（State Pattern）：
 * 允许对象在其内部状态改变时改变它的行为，使得对象看起来似乎修改了它的类。
 * 
 * 核心角色：
 * 1. State（状态接口）：VendingMachineState - 定义状态行为
 * 2. ConcreteState（具体状态）：IdleState、HasCoinState、DispensingState、SoldOutState
 * 3. Context（上下文）：VendingMachine - 维护当前状态，委托行为给状态对象
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("========== 自动售货机（状态模式演示） ==========\n");

        // 创建售货机，初始有3件商品
        VendingMachine machine = new VendingMachine(3);
        System.out.println("🏪 售货机初始化完成，库存：3 件商品");
        System.out.println("当前状态：" + machine.getCurrentState());

        System.out.println("\n" + "=".repeat(50));
        System.out.println("场景一：正常购买流程");
        System.out.println("=".repeat(50));
        
        machine.insertCoin();      // 投币
        machine.selectProduct();   // 选择商品
        machine.dispense();        // 出货

        System.out.println("\n" + "=".repeat(50));
        System.out.println("场景二：尝试不投币就选择商品");
        System.out.println("=".repeat(50));
        
        machine.selectProduct();   // 未投币就选择 → 失败

        System.out.println("\n" + "=".repeat(50));
        System.out.println("场景三：投币后退币");
        System.out.println("=".repeat(50));
        
        machine.insertCoin();      // 投币
        machine.refund();          // 退币

        System.out.println("\n" + "=".repeat(50));
        System.out.println("场景四：连续购买至售罄");
        System.out.println("=".repeat(50));
        
        // 购买剩余商品
        machine.insertCoin();
        machine.selectProduct();
        machine.dispense();

        machine.insertCoin();
        machine.selectProduct();
        machine.dispense();

        // 尝试在售罄时购买
        machine.insertCoin();

        System.out.println("\n" + "=".repeat(50));
        System.out.println("场景五：补货后恢复正常");
        System.out.println("=".repeat(50));
        
        machine.refill(5);         // 补货5件
        machine.insertCoin();
        machine.selectProduct();
        machine.dispense();

        System.out.println("\n" + "=".repeat(50));
        System.out.println("交互式演示（可选）");
        System.out.println("=".repeat(50));
        
        interactiveDemo();
    }

    /**
     * 交互式演示
     */
    private static void interactiveDemo() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\n是否进入交互模式？(y/n): ");
            String choice = sc.nextLine().trim().toLowerCase();
            
            if (!choice.equals("y")) {
                System.out.println("\n========== 演示结束 ==========");
                return;
            }

            System.out.print("请输入初始商品数量: ");
            int count = sc.nextInt();
            sc.nextLine(); // 消费换行符

            VendingMachine machine = new VendingMachine(count);
            System.out.println("\n🏪 售货机已创建，当前状态：" + machine.getCurrentState());

            boolean running = true;
            while (running) {
                System.out.println("\n" + "-".repeat(40));
                System.out.println("📋 操作菜单：");
                System.out.println("  1 - 投币");
                System.out.println("  2 - 选择商品");
                System.out.println("  3 - 退币");
                System.out.println("  4 - 补货");
                System.out.println("  5 - 查看状态");
                System.out.println("  0 - 退出");
                System.out.print("请选择操作: ");

                int option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 1:
                        machine.insertCoin();
                        break;
                    case 2:
                        machine.selectProduct();
                        machine.dispense();
                        break;
                    case 3:
                        machine.refund();
                        break;
                    case 4:
                        System.out.print("请输入补货数量: ");
                        int refillCount = sc.nextInt();
                        sc.nextLine();
                        machine.refill(refillCount);
                        break;
                    case 5:
                        System.out.println("\n📊 当前状态信息：");
                        System.out.println("   状态：" + machine.getCurrentState());
                        System.out.println("   库存：" + machine.getProductCount() + " 件");
                        break;
                    case 0:
                        running = false;
                        System.out.println("\n👋 感谢使用，再见！");
                        break;
                    default:
                        System.out.println("❌ 无效选项，请重新选择");
                }
            }

            System.out.println("\n========== 演示结束 ==========");
        }
    }
}
