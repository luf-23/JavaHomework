package DesiginPatternHomework.Observer;

public class Member implements Observer {
    private String name;

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(String productName, String fieldName, Object oldValue, Object newValue) {
        System.out.println("【通知会员 " + name + "】商品 [" + productName + "] 的 " + fieldName
                + " 已更新：" + oldValue + " → " + newValue);
    }
}

interface Observer {
    void update(String productName, String fieldName, Object oldValue, Object newValue);
}