package DesiginPatternHomework.AbstractFactory;

public class McDonaldsCola implements Cola {
    @Override
    public void pour() {
        System.out.println("正在倒麦当劳可口可乐...");
    }

    @Override
    public String getDescription() {
        return "麦当劳可口可乐 - 冰镇经典可乐，搭配汉堡的完美选择";
    }
}