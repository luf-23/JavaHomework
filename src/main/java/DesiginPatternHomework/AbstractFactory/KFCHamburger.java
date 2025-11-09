package DesiginPatternHomework.AbstractFactory;

public class KFCHamburger implements Hamburger{

    @Override
    public void make() {
        System.out.println("正在制作肯德基香辣鸡腿堡...");
    }

    @Override
    public String getDescription() {
        return "肯德基香辣鸡腿堡 - 香脆炸鸡腿肉，配生菜和特制酱料";
    }
}
