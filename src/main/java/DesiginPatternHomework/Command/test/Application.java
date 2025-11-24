package DesiginPatternHomework.Command.test;

import java.io.IOException;

/**
 * 应用程序类 - 接收者
 */
public class Application {
    private String name;
    private String exePath;
    private Process process;

    public Application(String name, String exePath) {
        this.name = name;
        this.exePath = exePath;
        this.process = null;
    }

    /**
     * 启动应用程序
     */
    public void start() {
        try {
            if (process != null && process.isAlive()) {
                System.out.println("⚠️  " + name + " 已经在运行中");
                return;
            }
            
            ProcessBuilder processBuilder = new ProcessBuilder(exePath);
            process = processBuilder.start();
            System.out.println("✅ " + name + " 已启动");
        } catch (IOException e) {
            System.err.println("❌ 启动 " + name + " 失败: " + e.getMessage());
        }
    }

    /**
     * 关闭应用程序
     */
    public void close() {
        if (process != null && process.isAlive()) {
            process.destroy();
            System.out.println("🛑 " + name + " 已关闭");
            process = null;
        } else {
            System.out.println("⚠️  " + name + " 未在运行");
        }
    }

    /**
     * 检查应用程序是否在运行
     */
    public boolean isRunning() {
        return process != null && process.isAlive();
    }

    public String getName() {
        return name;
    }

    public String getExePath() {
        return exePath;
    }
}
