package designpattern;

class EagerSingleton{

    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton(){ } //私有化构造方法

    private String paw = "I yao eat ren";

    public String getPaw(){
        return paw;
    }

    public static EagerSingleton getInstance(){
        return instance;
    }
}

public class basicSingleton {

    public static void main(String[] args) {
        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
        System.out.println(eagerSingleton.getPaw());
    }
}
