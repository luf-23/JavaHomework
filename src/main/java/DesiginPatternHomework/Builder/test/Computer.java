package DesiginPatternHomework.Builder.test;

public class Computer {
    private String cpu;
    private String ram;
    private String ssd;
    private String gpu;

    private Computer(Builder builder){
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.ssd = builder.ssd;
        this.gpu = builder.gpu;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", ssd='" + ssd + '\'' +
                ", gpu='" + gpu + '\'' +
                '}';
    }

    public static class Builder{
        private String cpu;
        private String ram;
        private String ssd;
        private String gpu;
        public Builder(String cpu){
            this.cpu = cpu;
        }
        public Builder buildRAM(String ram){
            this.ram = ram;
            return this;
        }
        public Builder buildSSD(String ssd){
            this.ssd = ssd;
            return this;
        }
        public Builder buildGPU(String gpu){
            this.gpu = gpu;
            return this;
        }
        public Computer build(){
            return new Computer(this);
        }
    }
}
