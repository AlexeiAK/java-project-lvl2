package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class AppTest {
    private static final String FILE_1 = "src/test/resources/file1.json";
    private static final String FILE_2 = "src/test/resources/file2.json";

    private static final String YML_FILE_1 = "src/test/resources/file1.yml";
    private static final String YML_FILE_2 = "src/test/resources/file2.yml";

    private static final String DIFF_TEST_STRING = "{\n"
        + "    chars1: [a, b, c]\n"
        + "  - chars2: [d, e, f]\n"
        + "  + chars2: false\n"
        + "  - checked: false\n"
        + "  + checked: true\n"
        + "  - default: null\n"
        + "  + default: [value1, value2]\n"
        + "  - id: 45\n"
        + "  + id: null\n"
        + "  - key1: value1\n"
        + "  + key2: value2\n"
        + "    numbers1: [1, 2, 3, 4]\n"
        + "  - numbers2: [2, 3, 4, 5]\n"
        + "  + numbers2: [22, 33, 44, 55]\n"
        + "  - numbers3: [3, 4, 5]\n"
        + "  + numbers4: [4, 5, 6]\n"
        + "  + obj1: {nestedKey=value, isNested=true}\n"
        + "  - setting1: Some value\n"
        + "  + setting1: Another value\n"
        + "  - setting2: 200\n"
        + "  + setting2: 300\n"
        + "  - setting3: true\n"
        + "  + setting3: none\n"
        + "}";

    @Test
    void whenJsonsThenDiff() throws Exception {
        Map<String, Object> parsedfile1 = Parser.generate(FILE_1);
        Map<String, Object> parsedfile2 = Parser.generate(FILE_2);

        Assertions.assertEquals(DIFF_TEST_STRING, Differ.generate(parsedfile1, parsedfile2, format));
    }

    @Test
    void whenYamlThenDiff() throws Exception {
        Map<String, Object> parsedfile1 = Parser.generate(YML_FILE_1);
        Map<String, Object> parsedfile2 = Parser.generate(YML_FILE_2);

        Assertions.assertEquals(DIFF_TEST_STRING, Differ.generate(parsedfile1, parsedfile2, format));
    }
}
