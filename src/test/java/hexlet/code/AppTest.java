package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

class AppTest {
    private static final String JSON_FILE_1 = "src/test/resources/file1.json";
    private static final String JSON_FILE_2 = "src/test/resources/file2.json";

    private static final String YML_FILE_1 = "src/test/resources/file1.yml";
    private static final String YML_FILE_2 = "src/test/resources/file2.yml";

    private final String plainFormat = "plain";
    private final String stylishFormat = "stylish";
    private final String jsonFormat = "json";

    @Test
    void whenFilesThenStylish() throws Exception {
        String actualJsons = Differ.generate(JSON_FILE_1, JSON_FILE_2, stylishFormat);
        String actualYmls = Differ.generate(YML_FILE_1, YML_FILE_2, stylishFormat);

        String expected = Files.readString(Paths.get("src/test/resources/fixtures/stylish"));

        Assertions.assertEquals(expected, actualJsons);
        Assertions.assertEquals(expected, actualYmls);
    }

    @Test
    void whenFilesThenPlain() throws Exception {
        String actualJsons = Differ.generate(JSON_FILE_1, JSON_FILE_2, plainFormat);
        String actualYmls = Differ.generate(YML_FILE_1, YML_FILE_2, plainFormat);

        String expected = Files.readString(Paths.get("src/test/resources/fixtures/plain"));

        Assertions.assertEquals(expected, actualJsons);
        Assertions.assertEquals(expected, actualYmls);
    }

    @Test
    void whenFilesThenJsons() throws Exception {
        String actualJsons = Differ.generate(JSON_FILE_1, JSON_FILE_2, jsonFormat);
        String actualYmls = Differ.generate(YML_FILE_1, YML_FILE_2, jsonFormat);

        String expected = Files.readString(Paths.get("src/test/resources/fixtures/json"));

        Assertions.assertEquals(expected, actualJsons);
        Assertions.assertEquals(expected, actualYmls);
    }
}
