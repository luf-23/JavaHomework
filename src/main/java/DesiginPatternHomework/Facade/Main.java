package DesiginPatternHomework.Facade;

public class Main {
    public static void main(String[] args) {
        System.out.println("====== 保安系统控制台 v1.0 ======");

        SecurityFacade security = new SecurityFacade();

        // 模拟保安操作：启动系统
        security.activate();

        // 假设一段时间后关闭
        try {
            Thread.sleep(2000); // 暂停2秒模拟运行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        security.deactivate();

        System.out.println("👋 保安操作完成。");
    }
}
