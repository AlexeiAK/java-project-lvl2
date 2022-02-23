package hexlet.code;

public class UnitOfDiff {
    private final String style;
    private final String key;
    private final Object value1;
    private final Object value2;

    public UnitOfDiff(String changesStyle, String unitKey, Object unitValue1, Object unitValue2) {
        this.style = changesStyle;
        this.key = unitKey;
        this.value1 = unitValue1;
        this.value2 = unitValue2;
    }


    public final String getChangesType() {
        return style;
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
