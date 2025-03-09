package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String tagBody;
    private List<Tag> children;

    public PairedTag(String title, Map<String, String> attributes, String tagBody, List<Tag> children) {
        super(title, attributes);
        this.tagBody = tagBody;
        this.children = children;
    }

    @Override
    public String toString() {
        var childrenTags = children.stream()
                .map(Tag::toString)
                .collect(Collectors.joining(""));

        return String.format("<%s%s>%s%s</%s>",
                super.getTitle(),
                super.getAttributesString(),
                tagBody,
                childrenTags,
                super.getTitle());
    }
}
// END
