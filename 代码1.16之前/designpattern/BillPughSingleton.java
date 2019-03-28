package designpattern;

public class BillPughSingleton {

    private BillPughSingleton() { }

    public static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }

    public static void main(String[] args) {
        BillPughSingleton singleton = BillPughSingleton.getInstance();
        System.out.println(singleton);

        BillPughSingleton singleton2 = BillPughSingleton.getInstance();
        System.out.println(singleton2);

        BillPughSingleton singleton3 = BillPughSingleton.getInstance();
        System.out.println(singleton3);

    }
}
