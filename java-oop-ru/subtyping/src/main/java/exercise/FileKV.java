package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String filePath;

    FileKV(String filePath, Map<String, String> storage) {
        this.filePath = filePath;
        Utils.writeFile(filePath, Utils.serialize(storage));
    }

    public void set(String key, String value) {
        var data = Utils.readFile(filePath);
        var dataMap = Utils.deserialize(data);
        dataMap.put(key, value);
        Utils.writeFile(filePath, Utils.serialize(dataMap));
    }

    public void unset(String key) {
        var data = Utils.readFile(filePath);
        var dataMap = Utils.deserialize(data);
        dataMap.remove(key);
        Utils.writeFile(filePath, Utils.serialize(dataMap));
    }

    public String get(String key, String defaultValue) {
        var data = Utils.readFile(filePath);
        var dataMap = Utils.deserialize(data);
        return dataMap.getOrDefault(key, defaultValue);
    }

    public Map<String, String> toMap() {
        var data = Utils.readFile(filePath);
        var dataMap = Utils.deserialize(data);
        return dataMap;
    }
}
// END
