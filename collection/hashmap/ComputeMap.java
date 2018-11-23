package collection.hashmap;

import java.util.HashMap;
import java.util.Map;

public class ComputeMap {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("1","100");
        map.put("2","500");
        map.put("3","1000");
        map.put(null,"2000");
        map.put("4",null);

        System.out.println(map);
        for(String key : map.keySet()){
            map.compute(key,(k,v) -> k + v);
        }
        System.out.println(map);

        for(Map.Entry entry : map.entrySet()){
            map.put((String) entry.getKey(),(String) entry.getKey() + entry.getValue());
        }
        System.out.println(map);

        map.compute("5",(k,v) -> k +v);
        System.out.println(map);
    }
}
