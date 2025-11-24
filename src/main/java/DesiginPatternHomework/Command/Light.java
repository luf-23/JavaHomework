package DesiginPatternHomework.Command;

public class Light {
    private String position;
    private boolean isOn;
    public Light(String  position) {
        this.position = position;
        this.isOn = false;
    }
    public void on() {
        System.out.println(position + "的💡灯已开启");
        this.isOn = true;
    }
    public void off() {
        System.out.println(position + "的💡灯已关闭");
        this.isOn = false;
    }

    public String getPosition() {
        return position;
    }

}
