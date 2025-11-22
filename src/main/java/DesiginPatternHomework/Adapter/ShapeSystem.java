package DesiginPatternHomework.Adapter;

// 目标接口
interface Shape {
    void draw();
}

// 系统原有图形类
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("绘制矩形");
    }
}

class Line implements Shape {
    @Override
    public void draw() {
        System.out.println("绘制直线");
    }
}

// 第三方提供的 Angle 类（接口不兼容）
class Angle {
    public void drawAngle() {
        System.out.println("绘制角度（使用 drawAngle 方法）");
    }
}

// 适配器：使 Angle 兼容 Shape 接口
class AngleAdapter implements Shape {
    private Angle angle;

    public AngleAdapter(Angle angle) {
        this.angle = angle;
    }

    @Override
    public void draw() {
        angle.drawAngle();
    }
}