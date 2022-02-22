package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

class AppTest {
    private static final String FILE_1 = "src/test/resources/file1.json";
    private static final String FILE_2 = "src/test/resources/file2.json";

    private static final String YML_FILE_1 = "src/test/resources/file1.yml";
    private static final String YML_FILE_2 = "src/test/resources/file2.yml";

    @Test
    void whenJsonsThenStylish() throws Exception {
        Map<String, Object> parsedfile1 = Parser.generate(FILE_1);
        Map<String, Object> parsedfile2 = Parser.generate(FILE_2);
        String format = "stylish";

        String actual = Differ.generate(parsedfile1, parsedfile2, format);
        String expected = Files.readString(Paths.get("src/test/resources/expected/stylish"));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void whenJsonsThenPlain() throws Exception {
        Map<String, Object> parsedfile1 = Parser.generate(FILE_1);
        Map<String, Object> parsedfile2 = Parser.generate(FILE_2);
        String format = "plain";

        String actual = Differ.generate(parsedfile1, parsedfile2, format);
        String expected = Files.readString(Paths.get("src/test/resources/expected/plain"));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void whenYamlsThenStylish() throws Exception {
        Map<String, Object> parsedfile1 = Parser.generate(YML_FILE_1);
        Map<String, Object> parsedfile2 = Parser.generate(YML_FILE_2);
        String format = "stylish";

        String actual = Differ.generate(parsedfile1, parsedfile2, format);
        String expected = Files.readString(Paths.get("src/test/resources/expected/stylish"));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void whenYamlsThenPlain() throws Exception {
        Map<String, Object> parsedfile1 = Parser.generate(YML_FILE_1);
        Map<String, Object> parsedfile2 = Parser.generate(YML_FILE_2);
        String format = "plain";

        String actual = Differ.generate(parsedfile1, parsedfile2, format);
        String expected = Files.readString(Paths.get("src/test/resources/expected/plain"));

        Assertions.assertEquals(expected, actual);
    }
}
