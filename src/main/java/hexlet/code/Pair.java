package hexlet.code;

public class Pair {
    private final String changesStyle;
    private final String key;
    private final Object value1;
    private final Object value2;

    public Pair(String style, String pairKey, Object pairValue1, Object pairValue2) {
        this.changesStyle = style;
        this.key = pairKey;
        this.value1 = pairValue1;
        this.value2 = pairValue2;
    }


    public final String getChangesType() {
        return changesStyle;
    }

    public final String getKey() {
        return key;
    }

    public final Object getValue1() {
        return value1;
    }

    public final Object getValue2() {
        return value2;
    }
}
