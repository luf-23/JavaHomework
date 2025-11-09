package DesiginPatternHomework.Singleton;

import java.util.HashMap;
import java.util.Map;

public class AppConfig {
    // volatile关键字确保多线程环境下的可见性和有序性
    private static volatile AppConfig instance;
    private static final Object lockObject = new Object();

    // 私有构造函数，防止外部实例化
    private AppConfig() {
        loadConfig();
    }

    private Map<String, String> configData;

    public static AppConfig getInstance() {
        if (instance == null) {
            synchronized (lockObject) {
                if (instance == null) {
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }

    private void loadConfig() {
        configData = new HashMap<>();
        configData.put("key1", "value1");
        configData.put("key2", "value2");
        configData.put("key3", "value3");
        System.out.println("配置文件已加载");
    }

    public String getConfigValue(String key) {
        return configData.getOrDefault(key, "");
    }

    public void setConfigValue(String key, String value) {
        configData.put(key, value);
    }

}