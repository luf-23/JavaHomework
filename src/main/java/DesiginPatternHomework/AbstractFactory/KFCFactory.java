package DesiginPatternHomework.AbstractFactory;

public class KFCFactory extends AbstractFastFoodFactory{
    @Override
    public Hamburger createHamburger() {
        return new KFCHamburger();
    }

    @Override
    public Cola createCola() {
        return new KFCCola();
    }

    @Override
    public String getStoreName() {
        return "肯德基 (KFC)";
    }
}
