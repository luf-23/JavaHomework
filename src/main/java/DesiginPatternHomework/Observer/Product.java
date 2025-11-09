package DesiginPatternHomework.Observer;

import java.util.ArrayList;
import java.util.List;

public class Product implements Subject {
    private String name;
    private double price;
    private List<Observer> observers;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.observers = new ArrayList<>();
    }

    // Getter
    public String getName() { return name; }
    public double getPrice() { return price; }

    // Setter with notification
    public void setName(String newName) {
        if (!this.name.equals(newName)) {
            String oldName = this.name;
            this.name = newName;
            notifyObservers("name", oldName, newName);
        }
    }

    public void setPrice(double newPrice) {
        if (this.price != newPrice) {
            double oldPrice = this.price;
            this.price = newPrice;
            notifyObservers("price", oldPrice, newPrice);
        }
    }

    // Subject 方法实现
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
        System.out.println("[系统] 会员 " + ((Member)o).getName() + " 订阅了商品 [" + this.name + "] 的变更通知");
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
        System.out.println("[系统] 会员 " + ((Member)o).getName() + " 取消订阅商品 [" + this.name + "]");
    }

    @Override
    public void notifyObservers() {
        // 本实现中通过 notifyObservers(field,...) 调用，此处可留空或复用
    }

    // 专用通知方法（带变更细节）
    private void notifyObservers(String fieldName, Object oldValue, Object newValue) {
        System.out.println("\n>>> 商品 [" + this.name + "] 的 [" + fieldName + "] 发生变更："
                + oldValue + " → " + newValue);
        for (Observer o : observers) {
            o.update(this.name, fieldName, oldValue, newValue);
        }
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + "}";
    }
}

// ===== 1. Subject 接口 =====
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

