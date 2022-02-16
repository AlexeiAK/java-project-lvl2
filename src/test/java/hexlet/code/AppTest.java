package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    final File file1 = new File("src/main/resources/file1.json");
    final File file2 = new File("src/main/resources/file2.json");

    @Test
    void whenJsonsThenDiff() throws Exception {
            String expected = "{\n" +
                    "  - follow: false\n" +
                    "    host: hexlet.io\n" +
                    "  - proxy: 123.234.53.22\n" +
                    "  - timeout: 50\n" +
                    "  + timeout: 20\n" +
                    "  + verbose: true\n" +
                    "}";

            assertEquals(expected, Differ.generate(file1, file2));
    }
}