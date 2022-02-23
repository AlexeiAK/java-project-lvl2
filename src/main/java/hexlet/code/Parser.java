package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.io.Files;

import java.io.FileReader;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    public static Map<String, Object> generate(String filepath1) throws Exception {
        final Path fileAbsolutePath = Paths.get(filepath1).toAbsolutePath();
        final String file = String.valueOf(fileAbsolutePath);

        final String fileFormat = Files.getFileExtension(filepath1);

        Map<String, Object> map = null;

        if (fileFormat.equals("yml")) {
            ObjectMapper ymlMapper = new ObjectMapper(new YAMLFactory());
            map = ymlMapper.readValue(new FileReader(file), new TypeReference<>() { });
        }
        if (fileFormat.equals("json")) {
            ObjectMapper jsonMapper = new ObjectMapper();
            map = jsonMapper.readValue(new FileReader(file), new TypeReference<>() { });
        }

        return map;
    }
}
