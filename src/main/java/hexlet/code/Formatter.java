package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;

public class Formatter {
    public final String getDiff(List<Pair> resultListOfPairs, String format) throws JsonProcessingException {
        return switch (format) {
            case ("stylish") -> Stylish.getFormatResult(resultListOfPairs);
            case ("plain") -> Plain.getFormatResult(resultListOfPairs);
            case ("json") -> Json.getFormatResult(resultListOfPairs);
            default -> "Unexpected value: " + format;
        };
    }
}
