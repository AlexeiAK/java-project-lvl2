package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class AppTest {
    private static final String FILE_1 = "src/test/resources/file1.json";
    private static final String FILE_2 = "src/test/resources/file2.json";

    private static final String YML_FILE_1 = "src/test/resources/file1.yml";
    private static final String YML_FILE_2 = "src/test/resources/file2.yml";

    @Test
    void whenJsonsThenDiff() throws Exception {
        Map<String, Object> parsedfile1 = Parser.generate(FILE_1);
        Map<String, Object> parsedfile2 = Parser.generate(FILE_2);

        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

        Assertions.assertEquals(expected, Differ.generate(parsedfile1, parsedfile2));
    }

    @Test
    void whenYamlThenDiff() throws Exception {
        Map<String, Object> parsedfile1 = Parser.generate(YML_FILE_1);
        Map<String, Object> parsedfile2 = Parser.generate(YML_FILE_2);

        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

        Assertions.assertEquals(expected, Differ.generate(parsedfile1, parsedfile2));
    }
}
