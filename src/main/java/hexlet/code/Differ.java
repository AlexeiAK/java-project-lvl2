package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format)
        throws Exception {

        Map<String, Object> map1 = Parser.generate(filepath1);
        Map<String, Object> map2 = Parser.generate(filepath2);

        Map<String, Object> allMaps = new TreeMap<>();
        allMaps.putAll(map1);
        allMaps.putAll(map2);

        List<UnitOfDiff> allDifferences = new ArrayList<>();

        for (Map.Entry<String, Object>  pair : allMaps.entrySet()) {
            String key = (String) pair.getKey();
            Object valueMap1 = (map1.get(key) == null) ? "null" : map1.get(key);
            Object valueMap2 = (map2.get(key) == null) ? "null" : map2.get(key);

            if (!map2.containsKey(key)) {
                allDifferences.add(new UnitOfDiff("removed", key, valueMap1, valueMap2));
            } else if (!map1.containsKey(key))  {
                allDifferences.add(new UnitOfDiff("added", key, valueMap1, valueMap2));
            } else if (valueMap1.equals(valueMap2)) {
                allDifferences.add(new UnitOfDiff("nothing", key, valueMap1, valueMap2));
            } else if (!valueMap1.equals(valueMap2)) {
                allDifferences.add(new UnitOfDiff("updated", key, valueMap1, valueMap2));
            }
        }

        Formatter formatter = new Formatter();
        return formatter.getDiff(allDifferences, format);
    }

    public static String generate(String filepath1, String filepath2)
        throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}
