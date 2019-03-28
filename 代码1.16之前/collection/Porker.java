package collection;

import java.util.*;

public class Porker {

    public static void main(String[] args) {

        String[] num = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        String[] color = {"方块", "梅花", "红桃", "黑桃"};

        HashMap<Integer, String> hm = new HashMap<>();
        int index = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for (String tnum : num) {
            for (String tcolor : color) {
                hm.put(index, tcolor.concat(tnum));
                list.add(index);
                index++;
            }
        }

        hm.put(index, "小王");
        list.add(index);
        index++;
        hm.put(index, "大王");
        list.add(index);

        /**洗牌*/
        Collections.shuffle(list);

        /**发牌*/
        TreeSet<Integer> a = new TreeSet<>();
        TreeSet<Integer> b = new TreeSet<>();
        TreeSet<Integer> c = new TreeSet<>();
        TreeSet<Integer> dipai = new TreeSet<>();

        for (int i = 0; i < list.size(); i++) {
            if (i >= list.size() - 3) {
                dipai.add(list.get(i));
            } else if (i % 3 == 0) {
                a.add(list.get(i));
            } else if (i % 3 == 1) {
                b.add(list.get(i));
            } else {
                c.add(list.get(i));
            }
        }

        /**看牌*/
        look(hm,a,"a");
        look(hm,b,"b");
        look(hm,c,"c");
        look(hm,dipai,"dipai");
    }

    public static void look(HashMap<Integer,String> hm,TreeSet<Integer> ts,String name){
        System.out.print(name+"的牌是：");
        for(Integer i :ts){
            System.out.print(hm.get(i)+" ");
        }
        System.out.println();
    }
}
