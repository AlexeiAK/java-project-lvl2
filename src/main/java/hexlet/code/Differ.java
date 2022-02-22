package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Differ {
    static String generate(Map<String, Object> map1, Map<String, Object> map2, String format)
        throws JsonProcessingException {
        Map<String, Object> allMaps = new TreeMap<>();
        allMaps.putAll(map1);
        allMaps.putAll(map2);

        Formatter formatter = new Formatter();
        List<Pair> resultListOfPairs = new ArrayList<>();

        for (Map.Entry<String, Object>  pair : allMaps.entrySet()) {
            String key = (String) pair.getKey();

            Object valueMap1 = (map1.get(key) == null) ? "null" : map1.get(key);
            Object valueMap2 = (map2.get(key) == null) ? "null" : map2.get(key);

            if (!map2.containsKey(key)) {
                resultListOfPairs.add(new Pair("removed", key, valueMap1, valueMap2));
            } else if (!map1.containsKey(key))  {
                resultListOfPairs.add(new Pair("added", key, valueMap1, valueMap2));
            } else if (valueMap1.equals(valueMap2)) {
                resultListOfPairs.add(new Pair("nothing", key, valueMap1, valueMap2));
            } else if (!valueMap1.equals(valueMap2)) {
                resultListOfPairs.add(new Pair("updated", key, valueMap1, valueMap2));
            }
        }

        return formatter.getDiff(resultListOfPairs, format);
    }
}
