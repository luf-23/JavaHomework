package DesiginPatternHomework.Facade;

public class SecurityFacade {
    private final Camera camera;
    private final Light light;
    private final Sensor sensor;
    private final Alarm alarm;

    public SecurityFacade() {
        this.camera = new Camera();
        this.light = new Light();
        this.sensor = new Sensor();
        this.alarm = new Alarm();
    }

    // 一键启动安保系统（合理顺序：灯 → 摄像头 → 感应器 → 警报器）
    public void activate() {
        System.out.println("\n【启动安保系统】");
        light.turnOn();
        camera.turnOn();
        sensor.activate();
        alarm.activate();
        System.out.println("✅ 安保系统已全面启动！\n");
    }

    // 一键关闭安保系统（反向顺序）
    public void deactivate() {
        System.out.println("\n【关闭安保系统】");
        alarm.deactivate();
        sensor.deactivate();
        camera.turnOff();
        light.turnOff();
        System.out.println("✅ 安保系统已完全关闭。\n");
    }
}

// ====== 子系统类：录像机 ======
class Camera {
    public void turnOn() {
        System.out.println("📹 摄像头已开启，开始录像...");
    }
    public void turnOff() {
        System.out.println("📹 摄像头已关闭，停止录像。");
    }
}

// ====== 子系统类：电灯 ======
class Light {
    public void turnOn() {
        System.out.println("💡 照明灯已开启，区域照亮。");
    }
    public void turnOff() {
        System.out.println("💡 照明灯已关闭。");
    }
}

// ====== 子系统类：红外感应器 ======
class Sensor {
    public void activate() {
        System.out.println("📡 红外感应器已激活，进入监控模式。");
    }
    public void deactivate() {
        System.out.println("📡 红外感应器已停用。");
    }
}

// ====== 子系统类：警报器 ======
class Alarm {
    public void activate() {
        System.out.println("🚨 警报器已待命，异常将触发警报！");
    }
    public void deactivate() {
        System.out.println("🚨 警报器已解除。");
    }
}