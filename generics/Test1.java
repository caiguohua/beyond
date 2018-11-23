package generics;
//Ê®Ò»ÔÂÆßºÅ
public class Test1<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public static void main(String[] args) {
        Test1<String> strType = new Test1<>();
        strType.setItem("20");
        System.out.println(strType.getItem());

        Test1 gType = new Test1();
        gType.setItem(20);
        System.out.println(gType.getItem());
    }
}
