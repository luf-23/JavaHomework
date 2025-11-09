package DesiginPatternHomework.AbstractFactory;

public abstract class AbstractFastFoodFactory {

    public abstract Hamburger createHamburger();

    public abstract Cola createCola();

    public abstract String getStoreName();
}
