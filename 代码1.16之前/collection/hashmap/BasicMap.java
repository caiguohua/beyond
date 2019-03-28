package collection.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BasicMap {

    public static void main(String[] args) {
        Map<String,String> data = new HashMap<>();
        data.put("A","AA");
        data.put("B","BB");
        data.put("C","CC");
        data.put("D","DD");
        data.put("E","EE");
        data.put(null,null);
        System.out.println(data);

        System.out.println(data.get("E"));
        System.out.println(data.get(null));

        System.out.println(data.getOrDefault("W","not existing"));

        System.out.println(data.containsKey("W"));
        System.out.println(data.size());

        Set<Map.Entry<String,String>> entryData = data.entrySet();
        entryData.forEach(System.out::println);

        String nullValue = data.remove(null);
        System.out.println(nullValue);
        System.out.println(data);
        System.out.println(data.values());
    }
}
