package designpattern;

public class StaticSingleton {

    private static StaticSingleton instance;

    private StaticSingleton(){ }

    static { //静态块只执行一次
        System.out.println("static instantiate");
        instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
        return instance;
    }

    @Override
    public String toString(){
        String ref = super.toString().split("@")[1];
        return "I am " + ref + ", a static block singleton";
    }

    public static void main(String[] args) {
        StaticSingleton singleton = StaticSingleton.getInstance();
        System.out.println(singleton);

        StaticSingleton singleton2 = StaticSingleton.getInstance();
        System.out.println(singleton2);

        StaticSingleton singleton3 = StaticSingleton.getInstance();
        System.out.println(singleton3);
    }

}
