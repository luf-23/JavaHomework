package DesiginPatternHomework.Decorator;

public class WaterWalkDecorator extends SheepDecorator {
    public WaterWalkDecorator(Sheep sheep) {
        super(sheep);
    }

    @Override
    public void run() {
        super.run();
        System.out.println("  → 可以在水面奔跑！");
    }
}
