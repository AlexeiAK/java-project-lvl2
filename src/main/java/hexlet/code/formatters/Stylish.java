package hexlet.code.formatters;

import hexlet.code.Node;

import java.util.List;

public class Stylish {

    public static String getFormated(List<Node> resultListOfPairs) {
        StringBuilder diff = new StringBuilder().append("{\n");

        for (Node pair : resultListOfPairs) {
            String key = pair.getKey();
            Object value1 = pair.getValue1();
            Object value2 = pair.getValue2();
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
