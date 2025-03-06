package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String filePath;
    private Map<String, String> storage;

    FileKV(String filePath, Map<String, String> storage) {
        this.filePath = filePath;
        this.storage = new HashMap<>(storage);
        Utils.writeFile(filePath, Utils.serialize(this.storage));
    }

    public void set(String key, String value) {
        storage.put(key, value);
        Utils.writeFile(filePath, Utils.serialize(this.storage));
    }

    public void unset(String key) {
        var data = Utils.readFile(filePath);
        storage = Utils.deserialize(data);
        storage.remove(key);
        Utils.writeFile(filePath, Utils.serialize(storage));
    }

    public String get(String key, String defaultValue) {
        var data = Utils.readFile(filePath);
        storage = Utils.deserialize(data);
        return storage.getOrDefault(key, defaultValue);
    }

    public Map<String, String> toMap() {
        var data = Utils.readFile(filePath);
        storage = Utils.deserialize(data);
        return new HashMap<>(storage);
    }
}
// END
