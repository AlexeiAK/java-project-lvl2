package hexlet.code;

import java.util.Map;
import java.util.TreeMap;

public class Differ {
    static String generate(Map<String, Object> map1, Map<String, Object> map2) {
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
