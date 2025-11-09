package DesiginPatternHomework.Bridge;

public class Milk implements CoffeeAdditives {
    @Override
    public String add() {
        return "加牛奶";
    }
}
