package hexlet.code;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Objects;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format)
        throws Exception {

        Map<String, Object> map1 = Parser.generate(filepath1);
        Map<String, Object> map2 = Parser.generate(filepath2);

        List<Node> diff = buildDiff(map1, map2);

        Formatter formatter = new Formatter();
        return formatter.getDiff(diff, format);
    }

    public static List<Node> buildDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> allKeys = new TreeSet<>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());

        List<Node> allDifferences = new ArrayList<>();

        for (String key: allKeys) {
            Object valueMap1 = (map1.get(key) == null) ? null : map1.get(key);
            Object valueMap2 = (map2.get(key) == null) ? null : map2.get(key);

            if (!map2.containsKey(key)) {
                allDifferences.add(new Node("removed", key, valueMap1, valueMap2));
            } else if (!map1.containsKey(key))  {
                allDifferences.add(new Node("added", key, valueMap1, valueMap2));
            } else if (Objects.equals(valueMap1, valueMap2)) {
                allDifferences.add(new Node("nothing", key, valueMap1, valueMap2));
            } else {
                allDifferences.add(new Node("updated", key, valueMap1, valueMap2));
            }
        }

        return allDifferences;
    }

    public static String generate(String filepath1, String filepath2)
        throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}
