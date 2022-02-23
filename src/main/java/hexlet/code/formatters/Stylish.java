package hexlet.code.formatters;

import hexlet.code.UnitOfDiff;

import java.util.List;

public class Stylish {

    public static String getFormated(List<UnitOfDiff> resultListOfPairs) {
        StringBuilder diff = new StringBuilder().append("{\n");

        for (UnitOfDiff pair : resultListOfPairs) {
            String key = pair.getUnitKey();
            Object value1 = pair.getUnitValue1();
            Object value2 = pair.getUnitValue2();
            String changesType = pair.getChangesType();

            if (changesType.equals("removed")) {
                diff.append("  - ")
                    .append(key)
                    .append(": ")
                    .append(value1)
                    .append("\n");
            }
            if (changesType.equals("added")) {
                diff.append("  + ")
                    .append(key)
                    .append(": ")
                    .append(value2)
                    .append("\n");
            }
            if (changesType.equals("nothing")) {
                diff.append("    ")
                    .append(key)
                    .append(": ")
                    .append(value1)
                    .append("\n");
            }
            if (changesType.equals("updated")) {
                diff.append("  - ")
                    .append(key)
                    .append(": ")
                    .append(value1)
                    .append("\n")

                    .append("  + ")
                    .append(key)
                    .append(": ")
                    .append(value2)
                    .append("\n");
            }
        }

        diff.append("}");
        return diff.toString();
    }
}
