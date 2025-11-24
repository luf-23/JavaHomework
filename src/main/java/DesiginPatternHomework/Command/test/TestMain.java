package DesiginPatternHomework.Command.test;

import java.util.Scanner;

/**
 * 命令模式测试 - 应用程序控制器
 * 通过控制台输入遥控器序号执行cmd命令控制程序的启动和关闭
 */
public class TestMain {
    public static void main(String[] args) {
        System.out.println("🚀 启动应用程序遥控器...\n");

        // 创建应用程序对象（接收者）
        Application chrome = new Application(
                "Google Chrome",
                "C:\\Users\\杨志军\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe"
        );
        Application hmcl = new Application(
                "HMCL Minecraft启动器",
                "E:\\Minecraft\\HMCL\\HMCL-3.6.20.exe"
        );
        Application pcl = new Application(
                "PCL Minecraft启动器",
                "E:\\Minecraft\\PCL\\PCL2.exe"
        );
        Application typora = new Application(
                "Typora编辑器",
                "E:\\typora\\Typora\\Typora.exe"
        );

        // 创建命令对象
        AppStartCommand chromeStart = new AppStartCommand(chrome);
        AppCloseCommand chromeClose = new AppCloseCommand(chrome);

        AppStartCommand hmclStart = new AppStartCommand(hmcl);
        AppCloseCommand hmclClose = new AppCloseCommand(hmcl);

        AppStartCommand pclStart = new AppStartCommand(pcl);
        AppCloseCommand pclClose = new AppCloseCommand(pcl);

        AppStartCommand typoraStart = new AppStartCommand(typora);
        AppCloseCommand typoraClose = new AppCloseCommand(typora);

        // 创建遥控器并配置命令
        AppRemoteControl remote = new AppRemoteControl();
        remote.setCommand(0, chromeStart, chromeClose);
        remote.setCommand(1, hmclStart, hmclClose);
        remote.setCommand(2, pclStart, pclClose);
        remote.setCommand(3, typoraStart, typoraClose);

        // 显示菜单
        remote.printMenu();

        // 控制台交互
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("\n请输入命令 > ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            String[] parts = input.split("\\s+");
            String command = parts[0].toLowerCase();

            try {
                switch (command) {
                    case "start":
                        if (parts.length < 2) {
                            System.out.println("❌ 请指定序号，例如: start 0");
                        } else {
                            int slot = Integer.parseInt(parts[1]);
                            remote.startApp(slot);
                        }
                        break;

                    case "close":
                        if (parts.length < 2) {
                            System.out.println("❌ 请指定序号，例如: close 0");
                        } else {
                            int slot = Integer.parseInt(parts[1]);
                            remote.closeApp(slot);
                        }
                        break;

                    case "undo":
                        remote.undo();
                        break;

                    case "menu":
                        remote.printMenu();
                        break;

                    case "exit":
                    case "quit":
                        System.out.println("👋 退出应用程序遥控器");
                        running = false;
                        break;

                    default:
                        System.out.println("❌ 未知命令: " + command);
                        System.out.println("💡 输入 'menu' 查看可用命令");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ 无效的序号格式");
            } catch (Exception e) {
                System.out.println("❌ 执行命令时出错: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("\n✅ 程序已退出");
    }
}
