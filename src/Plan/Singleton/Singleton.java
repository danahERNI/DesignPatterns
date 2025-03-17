package Plan.Singleton;

import java.util.HashMap;
import java.util.Map;

public class Singleton {
    public static void main(String[] args) {
        ConfigManager manager = ConfigManager.getInstance();
        manager.set("name", "Mosh");

        ConfigManager other = ConfigManager.getInstance();
        System.out.println(other.get("name"));
        
    }

}

class ConfigManager{
    private Map<String, Object> settings = new HashMap<>();
    private static ConfigManager instance = new ConfigManager();

    private ConfigManager() {}
    
    public void set(String key, Object value){
        settings.put(key, value);
    }

    public Object get(String key){
        return settings.get(key);
    }

    public static ConfigManager getInstance() {
        return instance;
    }
}