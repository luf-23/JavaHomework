package DesiginPatternHomework.Decorator;

public abstract class SheepDecorator implements Sheep {
    protected Sheep sheep;

    public SheepDecorator(Sheep sheep) {
        this.sheep = sheep;
    }

    @Override
    public void run() {
        sheep.run();
    }

    @Override
    public int getLives() {
        return sheep.getLives();
    }

    @Override
    public void loseLife() {
        sheep.loseLife();
    }
}