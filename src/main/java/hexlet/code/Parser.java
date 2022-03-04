package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.FileReader;
import java.util.Map;

public class Parser {
    public static Map<String, Object> generate(String content, String contentType) throws Exception {

        Map<String, Object> map;

        switch (contentType) {
            case "yml" -> {
                ObjectMapper ymlMapper = new ObjectMapper(new YAMLFactory());
                map = ymlMapper.readValue(new FileReader(content), new TypeReference<>() {
                });
            }
            case "json" -> {
                ObjectMapper jsonMapper = new ObjectMapper();
                map = jsonMapper.readValue(new FileReader(content), new TypeReference<>() {
                });
            }
            default -> {
                throw new Exception("Unexpected format: " + contentType);
            }
        }

        return map;
    }
}
