package DesiginPatternHomework.Strategy;

public class Book {
    private String title;
    private double price; // 原价
    private String type;  // "CS", "EN", "NOVEL" 等
    private DiscountStrategy strategy;

    public Book(String title, double price, String type) {
        this.title = title;
        this.price = price;
        this.type = type;
        // 初始化默认策略（无折扣）
        this.strategy = new NoDiscount();
    }

    // 动态设置策略
    public void setDiscountStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    // 计算折后价
    public double getDiscountedPrice() {
        return strategy.calculate(price);
    }

    // 根据类型自动匹配策略（可选辅助方法）
    public void applyStrategyByType() {
        switch (type.toUpperCase()) {
            case "CS":
                setDiscountStrategy(new ComputerDiscount());
                break;
            case "EN":
                setDiscountStrategy(new EnglishDiscount());
                break;
            case "NOVEL":
                setDiscountStrategy(new NovelDiscount());
                break;
            default:
                setDiscountStrategy(new NoDiscount()); // 默认无折扣
        }
    }

    @Override
    public String toString() {
        return String.format("《%s》 | 类型: %s | 原价: ¥%.2f | 折后价: ¥%.2f",
                title, type, price, getDiscountedPrice());
    }
}
