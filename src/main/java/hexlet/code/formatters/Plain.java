package hexlet.code.formatters;

import hexlet.code.UnitOfDiff;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String getFormated(List<UnitOfDiff> resultListOfPairs) {
        StringBuilder diff = new StringBuilder();

        for (UnitOfDiff pair : resultListOfPairs) {
            String key = pair.getKey();
            Object value1 = getRepresentStyleOfValue(pair.getValue1());
            Object value2 = getRepresentStyleOfValue(pair.getValue2());
            String changesType = pair.getChangesType();

            if (changesType.equals("removed")) {
                diff.append("Property '")
                    .append(key)
                    .append("' was removed")
                    .append("\n");
            }
            if (changesType.equals("added")) {
                diff.append("Property '")
                    .append(key)
                    .append("' was added with value: ")
                    .append(value2)
                    .append("\n");
            }
            if (changesType.equals("updated")) {
                diff.append("Property '")
                    .append(key)
                    .append("' was updated. ")
                    .append("From ")
                    .append(value1)
                    .append(" to ")
                    .append(value2)
                    .append("\n");
            }
        }

        // delete last "\n"
        diff.setLength(diff.length() - 1);

        return diff.toString();
    }

    private static Object getRepresentStyleOfValue(Object value) {
        if (value.equals("null")) {
            return value;
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (value instanceof Collection || value instanceof Map) {
            return "[complex value]";
        }

        return value;
    }
}
