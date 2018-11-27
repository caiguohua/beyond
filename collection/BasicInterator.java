package collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BasicInterator {
    public static void main(String[] args) {
        List<String> names = new LinkedList<>();
        names.add("brenly");
        names.add("ashley");
        names.add("bug");
        Iterator<String> namesIterator = names.iterator();
        while(namesIterator.hasNext()){
            System.out.println(namesIterator);
        }
    }

}
