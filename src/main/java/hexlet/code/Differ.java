package hexlet.code;

import java.util.Map;
import java.util.TreeMap;

public class Differ {
    static String generate(Map<String, Object> map1, Map<String, Object> map2, String format) {
        Map<String, Object> diffMap = new TreeMap<>();
        diffMap.putAll(map1);
        diffMap.putAll(map2);

        String diff = "{\n";

        for (Map.Entry pair : diffMap.entrySet()) {
            String key = (String) pair.getKey();

            Object valueMap1 = (map1.get(key) == null) ? "null" : map1.get(key);
            Object valueMap2 = (map2.get(key) == null) ? "null" : map2.get(key);

            if (!map2.containsKey(key)) {
                diff += "  - " + key + ": " + valueMap1 + "\n";
            } else if (!map1.containsKey(key))  {
                diff += "  + " + key + ": " + valueMap2 + "\n";
            } else if (valueMap1.equals(valueMap2)) {
                diff += "    " + key + ": " + valueMap1 + "\n";
            } else if (!valueMap1.equals(valueMap2)) {
                diff += "  - " + key + ": " + valueMap1 + "\n";
                diff += "  + " + key + ": " + valueMap2 + "\n";
            }
        }

        return diff  + "}";
    }
}

/*
* (-  removed) если значение в 1 есть, в 2 нет
* (   nothing) если значение в 1 есть, в 2 равно
* (-+ updated) если значение в 1 есть, в 2 неравно
* (+  added)   если значение в 1 нет, в 2 есть
 */
