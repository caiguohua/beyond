package collection;

import java.util.HashSet;
import java.util.Iterator;

public class Hashset {

    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add("a");
        set.add("b");
        set.add("c");
        Iterator iter = set.iterator();
        while(iter.hasNext()){
            String value = (String)iter.next();
            System.out.println(value);
        }
    }
}
