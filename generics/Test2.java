package generics;

public class Test2 {
    private static <T> boolean isEqual(Test1<T> g1,Test1<T> g2){
        return g1.getItem().equals(g2.getItem());
    }

    private static <T extends Comparable<T>> int compare(T t1,T t2){
        return t1.compareTo(t2);
    }

    private static <T> void _(T p){
        System.out.println(p);
    }

    public static void main(String[] args) {
        Test1<String> g1 = new Test1<>();
        g1.setItem("shaanxi");

        Test1<String> g2 = new Test1<>();
        g1.setItem("shaanxi");

        System.out.println(Test2.isEqual(g1,g2));

        System.out.println(Test2.compare(10,11));
    }
}