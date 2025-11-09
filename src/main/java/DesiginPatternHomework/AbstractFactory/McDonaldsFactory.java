package DesiginPatternHomework.AbstractFactory;

public class McDonaldsFactory extends AbstractFastFoodFactory{
    @Override
    public Hamburger createHamburger() {
        return new McDonaldsHamburger();
    }

    @Override
    public Cola createCola() {
        return new McDonaldsCola();
    }

    @Override
    public String getStoreName() {
        return "麦当劳 (McDonald's)";
    }
}
