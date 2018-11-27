package collection.arraylist;

import java.util.ArrayList;
import java.util.List;

public class BasicList {
    public static void main(String[] args) {
        List<String> vowels = new ArrayList<>();

        vowels.add("E");
        vowels.add("I");
        vowels.add(0,"A");
        System.out.println(vowels);


        List<String> addon = new ArrayList<>();
        addon.add("O");
        addon.add("U");
        vowels.addAll(addon);
        System.out.println(vowels);

        addon.clear();
        System.out.println(vowels);
        System.out.println(vowels.size());

        vowels.clear();
        System.out.println(vowels.size());

        vowels.add("E");
        vowels.add("E");
        vowels.add("I");
        vowels.add("O");
        addon = vowels.subList(0,2);
        System.out.println("vowels:" + vowels + "addon:" + addon);

        vowels.set(0,"A");
        System.out.println(vowels);
        vowels.add("U");
        System.out.println(vowels);
    }
}
