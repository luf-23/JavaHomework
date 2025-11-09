package DesiginPatternHomework.Builder;

public class Car {
    private String wheel;
    private String oilBox;
    private String body;

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    public void setOilBox(String oilBox) {
        this.oilBox = oilBox;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void show() {
        System.out.println("=== 汽车配置 ===");
        System.out.println("车轮: " + wheel);
        System.out.println("油箱: " + oilBox);
        System.out.println("车身: " + body);
        System.out.println("================");
    }
}