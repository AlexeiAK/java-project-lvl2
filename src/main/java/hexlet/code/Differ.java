package hexlet.code;

import java.io.File;
import java.io.FileReader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.TreeMap;

public class Differ {
    static String generate(File file1, File file2) throws Exception {
        String file1PathString = file1.toString();
        String file2PathString = file2.toString();

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> map1 = mapper.readValue(new FileReader(file1PathString), new TypeReference<>() { });
        Map<String, Object> map2 = mapper.readValue(new FileReader(file2PathString), new TypeReference<>() { });

        Map<String, Object> diffMap = new TreeMap<>();
        diffMap.putAll(map1);
        diffMap.putAll(map2);

        String diff = "{\n";

        for (Map.Entry pair : diffMap.entrySet()) {
            String key = (String) pair.getKey();

            Object valueMap1 = map1.get(key);
            Object valueMap2 =  map2.get(key);

            if (valueMap2 == null) {
                diff += "  - " + key + ": " + valueMap1 + "\n";
            } else if (valueMap1 == null) {
                diff += "  + " + key + ": " + valueMap2 + "\n";
            } else if (valueMap1.equals(valueMap2)) {
                diff += "    " + key + ": " + valueMap1 + "\n";
            } else {
                diff += "  - " + key + ": " + valueMap1 + "\n";
                diff += "  + " + key + ": " + valueMap2 + "\n";
            }
        }

        return diff  + "}";
    }
}
