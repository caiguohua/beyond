package collection.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleDict {

    public static void main(String[] args) {
        Map<String, List<String>> dict = new HashMap<>();

        List<String> listA = new ArrayList<>();
        listA.add("apple");
        listA.add("abandon");
        listA.add("adapt");
        listA.add("adult");

        List<String> listB = new ArrayList<>();
        listB.add("banner");
        listB.add("bug");
        listB.add("bush");
        listB.add("banana");

        List<String> listC = new ArrayList<>();
        listC.add("car");
        listC.add("char");
        listC.add("cat");
        listC.add("cut");

        List<String> listD = new ArrayList<>();
        listD.add("dog");
        listD.add("dash");
        listD.add("dot");
        listD.add("delegate");

        dict.put("a",listA);
        dict.put("b",listB);
        dict.put("c",listC);
        dict.put("d",listD);

        for(Map.Entry<String,List<String>> entry : dict.entrySet()){
            System.out.print(entry.getKey()+":");
            System.out.println(entry.getValue());
        }
    }
}
