package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    public SingleTag(String title, Map<String, String> attributes) {
        super(title, attributes);
    }

    @Override
    public String toString() {
        return String.format("<%s%s>", super.getTitle(), super.getAttributesString());
    }
}
// END
