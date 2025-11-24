package DesiginPatternHomework.Command;

// 音响
public class Stereo {
    private String posistion;
    private boolean isOn;
    private int volume;
    public Stereo(String posistion) {
        this.posistion = posistion;
        this.isOn = false;
        this.volume = 0;
    }

    public void on() {
        System.out.println(posistion+"的音响已开启");
        this.isOn = true;
    }

    public void off() {
        System.out.println(posistion+"的音响已关闭");
        this.isOn = false;
    }

    public void setVolume(int volume) {
        System.out.println(posistion+"的音响音量已设置为："+volume);
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }
    public String getPosistion() {
        return posistion;
    }
}
