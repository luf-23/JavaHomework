package DesiginPatternHomework.Command;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== 命令模式测试 ==========\n");

        // 创建接收者（智能家居设备）
        Light livingRoomLight = new Light("客厅");
        Light bedroomLight = new Light("卧室");
        Stereo stereo = new Stereo("客厅");

        // 创建具体命令对象
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        LightOnCommand bedroomLightOn = new LightOnCommand(bedroomLight);
        LightOffCommand bedroomLightOff = new LightOffCommand(bedroomLight);

        StereoOnCommand stereoOn = new StereoOnCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);
        StereoSetVolumeCommand stereoSetVolume = new StereoSetVolumeCommand(stereo, 50);

        // 创建遥控器
        RemoteControl remoteControl = new RemoteControl();

        // 为遥控器的插槽设置命令
        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, bedroomLightOn, bedroomLightOff);
        remoteControl.setCommand(2, stereoOn, stereoOff);

        // 显示遥控器配置
        remoteControl.printRemoteControl();

        // 测试命令执行
        System.out.println(">>> 测试客厅灯:");
        remoteControl.onButtonPressed(0);  // 打开客厅灯
        System.out.println();

        remoteControl.offButtonPressed(0); // 关闭客厅灯
        System.out.println();

        System.out.println(">>> 测试撤销功能:");
        remoteControl.undoButtonPressed(); // 撤销（客厅灯又开了）
        System.out.println();

        System.out.println(">>> 测试卧室灯:");
        remoteControl.onButtonPressed(1);  // 打开卧室灯
        System.out.println();

        System.out.println(">>> 测试音响:");
        remoteControl.onButtonPressed(2);  // 打开音响
        stereoSetVolume.execute();         // 设置音量
        System.out.println();

        System.out.println(">>> 测试撤销音量设置:");
        stereoSetVolume.undo();            // 撤销音量设置
        System.out.println();

        remoteControl.offButtonPressed(2); // 关闭音响
        System.out.println();

        System.out.println(">>> 多次撤销测试:");
        remoteControl.undoButtonPressed(); // 撤销关闭音响（音响重新开启）
        System.out.println();
        remoteControl.undoButtonPressed(); // 撤销打开卧室灯（卧室灯关闭）
        System.out.println();
        remoteControl.undoButtonPressed(); // 撤销上次操作
        System.out.println();

        System.out.println("========== 测试完成 ==========");
    }
}
