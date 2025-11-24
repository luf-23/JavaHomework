package DesiginPatternHomework.Command;

import java.util.Stack;

public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private Stack<Command> undoStack;

    public RemoteControl() {
        onCommands = new Command[7]; // 7个插槽
        offCommands = new Command[7];
        undoStack = new Stack<>();

        // 初始化为空命令，避免空指针
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    // 设置某个插槽的命令
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        if (slot >= 0 && slot < 7) {
            onCommands[slot] = onCommand;
            offCommands[slot] = offCommand;
        }
    }

    // 按下"开"按钮
    public void onButtonPressed(int slot) {
        if (slot >= 0 && slot < 7) {
            onCommands[slot].execute();
            undoStack.push(onCommands[slot]);
        }
    }

    // 按下"关"按钮
    public void offButtonPressed(int slot) {
        if (slot >= 0 && slot < 7) {
            offCommands[slot].execute();
            undoStack.push(offCommands[slot]);
        }
    }

    // 撤销上一个命令
    public void undoButtonPressed() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            command.undo();
        } else {
            System.out.println("没有可撤销的命令");
        }
    }

    // 打印遥控器状态
    public void printRemoteControl() {
        System.out.println("\n------ 遥控器配置 ------");
        for (int i = 0; i < onCommands.length; i++) {
            System.out.println("[插槽 " + i + "] " +
                    onCommands[i].getObjectName() + onCommands[i].getClass().getSimpleName() + "    " +
                    offCommands[i].getObjectName() + offCommands[i].getClass().getSimpleName());
        }
        System.out.println("------------------------\n");
    }
}

// 空命令对象（空对象模式）
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
