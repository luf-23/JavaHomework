package DesiginPatternHomework.Command;

public interface Command {
    void execute();
    void undo();
    //通常不需要
    String getObjectName();
}

class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.on();
    }
    @Override
    public void undo() {
        light.off();
    }

    @Override
    public String getObjectName() {
        return light.getPosition();
    }
}

class LightOffCommand implements Command {
    private Light light;
    public LightOffCommand(Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.off();
    }
    @Override
    public void undo() {
        light.on();
    }
    @Override
    public String getObjectName() {
        return light.getPosition();
    }
}

class StereoOnCommand implements Command {
    private Stereo stereo;
    public StereoOnCommand(Stereo stereo) {
        this.stereo = stereo;
    }
    @Override
    public void execute() {
        stereo.on();
    }
    @Override
    public void undo() {
        stereo.off();
    }
    @Override
    public String getObjectName() {
        return stereo.getPosistion();
    }
}

class StereoOffCommand implements Command {
    private Stereo stereo;
    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }
    @Override
    public void execute() {
        stereo.off();
    }
    @Override
    public void undo() {
        stereo.on();
    }
    @Override
    public String getObjectName() {
        return stereo.getPosistion();
    }
}

class StereoSetVolumeCommand implements Command {
    private Stereo stereo;
    private int preVolume;
    private int targetVolume;

    public StereoSetVolumeCommand(Stereo stereo, int targetVolume) {
        this.stereo = stereo;
        this.preVolume = stereo.getVolume();
        this.targetVolume = targetVolume;
    }
    @Override
    public void execute() {
        stereo.setVolume(targetVolume);
    }
    @Override
    public void undo() {
        stereo.setVolume(preVolume);
    }
    @Override
    public String getObjectName() {
        return stereo.getPosistion();
    }
}