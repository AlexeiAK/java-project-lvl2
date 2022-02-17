package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

class AppTest {
    private final File file1 = new File("src/test/resources/file1.json");
    private final File file2 = new File("src/test/resources/file2.json");

    @Test
    void whenJsonsThenDiff() throws Exception {
        String expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";

        Assertions.assertEquals(expected, Differ.generate(file1, file2));
    }
}
