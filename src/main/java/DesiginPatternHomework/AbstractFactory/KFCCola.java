package DesiginPatternHomework.AbstractFactory;

public class KFCCola implements Cola{

    @Override
    public void pour() {
        System.out.println("正在倒肯德基百事可乐...");
    }

    @Override
    public String getDescription() {
        return "肯德基百事可乐 - 冰镇百事可乐，与炸鸡汉堡的绝配";
    }
}
