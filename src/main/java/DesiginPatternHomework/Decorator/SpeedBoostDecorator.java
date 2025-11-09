package DesiginPatternHomework.Decorator;

public class SpeedBoostDecorator extends SheepDecorator {
    public SpeedBoostDecorator(Sheep sheep) {
        super(sheep);
    }

    @Override
    public void run() {
        super.run();
        System.out.println("  → 奔跑速度提升50%！");
    }
}