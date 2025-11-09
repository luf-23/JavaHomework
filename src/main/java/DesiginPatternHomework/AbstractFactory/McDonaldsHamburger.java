package DesiginPatternHomework.AbstractFactory;

public class McDonaldsHamburger implements Hamburger {
    @Override
    public void make() {
        System.out.println("正在制作麦当劳巨无霸汉堡...");
    }
    @Override
    public String getDescription() {
        return "麦当劳巨无霸汉堡 - 经典牛肉汉堡，配生菜、芝士和特制酱料";
    }
}