package hexlet.code.formatters;

import hexlet.code.Pair;

import java.util.List;

public class Stylish {

    public static String getFormatResult(List<Pair> resultListOfPairs) {
        String diff = "{\n";

        for (Pair pair : resultListOfPairs) {
            String key = pair.getKey();
            Object value1 = pair.getValue1();
            Object value2 = pair.getValue2();
            String changesType = pair.getChangesType();

            if (changesType.equals("removed")) {
                diff += "  - " + key + ": " + value1 + "\n";
            }
            if (changesType.equals("added")) {
                diff += "  + " + key + ": " + value2 + "\n";
            }
            if (changesType.equals("nothing")) {
                diff += "    " + key + ": " + value1 + "\n";
            }
            if (changesType.equals("updated")) {
                diff += "  - " + key + ": " + value1 + "\n";
                diff += "  + " + key + ": " + value2 + "\n";
            }
        }

        return diff + "}";
    }
}
