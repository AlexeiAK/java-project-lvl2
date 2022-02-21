package hexlet.code;

import hexlet.code.formatters.Stylish;

import java.util.List;

public class Formatter {
    public final String getDiff(List<Pair> resultListOfPairs, String format) {
        return switch (format) {
            case ("stylish") -> Stylish.getFormatResult(resultListOfPairs);
            default -> "Unexpected value: " + format;
        };
    }
}
