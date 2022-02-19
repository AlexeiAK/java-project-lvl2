package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.io.Files;

import java.io.FileReader;

import java.util.Map;

public class Parser {
    public static Map<String, Object> generate(String file) throws Exception {
        String fileFormat = Files.getFileExtension(file);

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
