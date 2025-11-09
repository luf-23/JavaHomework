package DesiginPatternHomework.Singleton;

public class Main {
    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();
        AppConfig appConfig2 = AppConfig.getInstance();
        System.out.println(appConfig == appConfig2);
        System.out.println(appConfig);
        System.out.println(appConfig2);
    }
}
