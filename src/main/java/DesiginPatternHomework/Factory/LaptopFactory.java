package DesiginPatternHomework.Factory;

public class LaptopFactory {
    public static Laptop createLaptop(String brand, String model) {
        switch (brand.toLowerCase()) {
            case "hp":
                return new HPLaptop(model);
            case "acer":
                return new AcerLaptop(model);
            case "lenovo":
                return new LenovoLaptop(model);
            case "dell":
                return new DellLaptop(model);
            default:
                throw new IllegalArgumentException("不支持的品牌: " + brand);
        }
    }
}