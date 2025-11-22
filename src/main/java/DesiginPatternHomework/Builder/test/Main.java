package DesiginPatternHomework.Builder.test;

public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer.Builder("Intel Core i7")
                .buildGPU("NVIDIA GeForce GTX 1080")
                .buildRAM("16GB")
                .buildSSD("512GB")
                .build();
        System.out.println(computer);
        System.out.println("--------------------------------");
        Computer computer2 = new Computer.Builder("Intel Core i5")
                .buildRAM("8GB")
                .build();
        System.out.println(computer2);
        System.out.println("--------------------------------");
        Computer computer3 = new Computer.Builder("Intel Core i3")
                .build();
        System.out.println(computer3);
    }
}
