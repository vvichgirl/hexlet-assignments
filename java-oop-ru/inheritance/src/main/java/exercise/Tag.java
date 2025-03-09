package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private String title;
    private Map<String, String> attributes;

    public Tag(String title, Map<String, String> attributes) {
        this.title = title;
        this.attributes = attributes;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public String getTitle() {
        return title;
    }

    public String getAttributesString() {
        return attributes.entrySet().stream()
                .map((entry) -> {
                    return String.format(" %s=\"%s\"", entry.getKey(), entry.getValue());
                })
                .collect(Collectors.joining(""));
    }
}
// END
