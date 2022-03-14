package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

class AppTest {
    private static final String JSON_FILE_1 = makeFullPathForTestFile("file1.json");
    private static final String JSON_FILE_2 = makeFullPathForTestFile("file2.json");

    private static final String YML_FILE_1 = makeFullPathForTestFile("file1.yml");
    private static final String YML_FILE_2 = makeFullPathForTestFile("file2.yml");

    private final String plainFormat = "plain";
    private final String stylishFormat = "stylish";
    private final String jsonFormat = "json";

    private static String makeFullPathForTestFile(String fileName) {
        return "src/test/resources/" + fileName;
    }

    private static String makeFullPathForFixtureFile(String fileName) {
        return "src/test/resources/fixtures/" + fileName;
    }

    @Test
    void whenFilesWithoutSpecifiedFormatThenDefaultFormat() throws Exception {
        String actualJsons = Differ.generate(JSON_FILE_1, JSON_FILE_2);
        String actualYmls = Differ.generate(YML_FILE_1, YML_FILE_2);

        String stylishPath = makeFullPathForFixtureFile(stylishFormat);
        String expected = Files.readString(Paths.get(stylishPath));

        Assertions.assertEquals(expected, actualJsons);
        Assertions.assertEquals(expected, actualYmls);
    }

    @Test
    void whenFilesThenStylish() throws Exception {
        String actualJsons = Differ.generate(JSON_FILE_1, JSON_FILE_2, stylishFormat);
        String actualYmls = Differ.generate(YML_FILE_1, YML_FILE_2, stylishFormat);

        String stylishPath = makeFullPathForFixtureFile(stylishFormat);
        String expected = Files.readString(Paths.get(stylishPath));

        Assertions.assertEquals(expected, actualJsons);
        Assertions.assertEquals(expected, actualYmls);
    }

    @Test
    void whenFilesThenPlain() throws Exception {
        String actualJsons = Differ.generate(JSON_FILE_1, JSON_FILE_2, plainFormat);
        String actualYmls = Differ.generate(YML_FILE_1, YML_FILE_2, plainFormat);

        String plainPath = makeFullPathForFixtureFile(plainFormat);
        String expected = Files.readString(Paths.get(plainPath));

        Assertions.assertEquals(expected, actualJsons);
        Assertions.assertEquals(expected, actualYmls);
    }

    @Test
    void whenFilesThenJsons() throws Exception {
        String actualJsons = Differ.generate(JSON_FILE_1, JSON_FILE_2, jsonFormat);
        String actualYmls = Differ.generate(YML_FILE_1, YML_FILE_2, jsonFormat);

        String jsonPath = makeFullPathForFixtureFile(jsonFormat);
        String expected = Files.readString(Paths.get(jsonPath));

        Assertions.assertEquals(expected, actualJsons);
        Assertions.assertEquals(expected, actualYmls);
    }
}
