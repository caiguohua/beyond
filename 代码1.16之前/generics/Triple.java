package generics;


public class Triple<T extends Number & Comparable<T>> {
    private T value1;
    private T value2;
    private T value3;

    public Triple(T value1, T value2, T value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public T getValue1() {
        return value1;
    }

    public void setValue1(T value1) {
        this.value1 = value1;
    }

    private T addValues(){
        Number result = value1.doubleValue()+value2.doubleValue()+value3.doubleValue();
        return (T)result;
    }

    private T largest(){
        T result = value1;
        if(value3.compareTo(result) > 0){
            result = value3;
        }
        if(value2.compareTo(result) > 0){
            result = value2;
        }
        return result;
    }

    public static void main(String[] args) {
        Triple<Float> t = new Triple<>(1000.8f,389.2f,666.6f);
        System.out.println(t.getValue1());
        System.out.println(t.addValues());
        System.out.println(t.largest());
        t.setValue1(100.2f);
        System.out.println(t.largest());
        System.out.println(0.1+0.2);
    }
}
