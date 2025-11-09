package DesiginPatternHomework.Adapter;

public class Main {
    public static void main(String[] args) {
        // 创建统一的 Shape 数组，包含适配后的 Angle
        Shape[] shapes = {
                new Circle(),
                new Rectangle(),
                new Line(),
                new AngleAdapter(new Angle())
        };

        System.out.println("用户统一调用 draw() 方法：");
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
