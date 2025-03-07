package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private String label;
    private TagInterface tag;

    public LabelTag(String label, TagInterface tag) {
        this.label = label;
        this.tag = tag;
    }

    @Override
    public String render() {
        return "<label>" + label + tag.render() + "</label>";
    }
}
// END
