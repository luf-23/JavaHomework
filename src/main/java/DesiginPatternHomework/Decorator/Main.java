package DesiginPatternHomework.Decorator;

public class Main {
    public static void main(String[] args) {
        // 初始喜羊羊
        Sheep sheep = new HappySheep();
        sheep.run();
        sheep.loseLife();
        System.out.println("当前生命：" + sheep.getLives());

        System.out.println("--- 吃了一个红苹果（保护罩） ---");
        sheep = new ShieldDecorator(sheep);
        sheep.run();
        System.out.println("--- 吃了一个绿苹果（加速） ---");
        sheep = new SpeedBoostDecorator(sheep);
        System.out.println("--- 吃了一个黄苹果（趟水） ---");
        sheep = new WaterWalkDecorator(sheep);
        sheep.loseLife();
        sheep.loseLife();
        sheep.run();
    }
}
