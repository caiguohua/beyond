package generics;

import java.util.HashMap;
import java.util.Objects;

public class WordStats {
    private static <T>HashMap<T,Integer> wordCount(T group[]){
        HashMap<T,Integer> map = new HashMap<>();
        for(T member : group){
            if(Objects.isNull(map.get(member))){
                map.put(member,1);
            }else {
                map.put(member,map.get(member)+1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Integer demo[] = {10,12,235,23,8,98,121,98,10,10};
        HashMap<?,Integer> mapNumber = wordCount(demo);
        System.out.println(mapNumber);

        String demo2 = "hi hello helen how are you";
        String[] words = demo2.split(" ");
        HashMap<?,Integer> mapWords = wordCount(words);
        System.out.println(mapWords);
    }
}
