package generics;

public class InheritGenerics {

    public static class MyClass<T>{

    }

    public static void main(String[] args) {
        String str = "dharma";
        Object obj = str;
        System.out.println(obj);

        MyClass<String> myClass1 = new MyClass<>();
        MyClass<Object> myClass2 = new MyClass<>();
        obj = myClass1;
        System.out.println(obj);
    }
}
