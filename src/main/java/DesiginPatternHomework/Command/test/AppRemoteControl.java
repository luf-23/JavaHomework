package DesiginPatternHomework.Command.test;

import DesiginPatternHomework.Command.Command;
import java.util.Stack;

/**
 * 应用程序遥控器
 */
public class AppRemoteControl {
    private Command[] startCommands;
    private Command[] closeCommands;
    private Stack<Command> undoStack;

    public AppRemoteControl() {
        startCommands = new Command[7];
        closeCommands = new Command[7];
        undoStack = new Stack<>();

        // 初始化为空命令
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            startCommands[i] = noCommand;
            closeCommands[i] = noCommand;
        }
    }

    /**
     * 设置插槽命令
     */
    public void setCommand(int slot, Command startCommand, Command closeCommand) {
        if (slot >= 0 && slot < 7) {
            startCommands[slot] = startCommand;
            closeCommands[slot] = closeCommand;
        }
    }

    /**
     * 启动应用
     */
    public void startApp(int slot) {
        if (slot >= 0 && slot < 7) {
            startCommands[slot].execute();
            undoStack.push(startCommands[slot]);
        }
    }

    /**
     * 关闭应用
     */
    public void closeApp(int slot) {
        if (slot >= 0 && slot < 7) {
            closeCommands[slot].execute();
            undoStack.push(closeCommands[slot]);
        }
    }

    /**
     * 撤销操作
     */
    public void undo() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
        } else {
            System.out.println("⚠️  没有可撤销的命令");
        }
    }

    /**
     * 显示遥控器配置
     */
    public void printMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║     🎮 应用程序遥控器控制面板 🎮       ║");
        System.out.println("╠════════════════════════════════════════╣");
        for (int i = 0; i < startCommands.length; i++) {
            String appName = startCommands[i].getObjectName();
            if (!appName.isEmpty()) {
                System.out.printf("║ [%d] %-34s ║%n", i, appName);
            }
        }
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║ 操作指令:                              ║");
        System.out.println("║   start [序号] - 启动应用              ║");
        System.out.println("║   close [序号] - 关闭应用              ║");
        System.out.println("║   undo         - 撤销上一个操作        ║");
        System.out.println("║   menu         - 显示此菜单            ║");
        System.out.println("║   exit         - 退出程序              ║");
        System.out.println("╚════════════════════════════════════════╝");
    }
}

/**
 * 空命令
 */
class NoCommand implements Command {
    @Override
    public void execute() {
        // 什么都不做
    }

    @Override
    public void undo() {
        // 什么都不做
    }

    @Override
    public String getObjectName() {
        return "";
    }
}
