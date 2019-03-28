package java8;

public class AdvanceLamda {

    public static void engine(Calculator calculator) {
        int x = 2, y = 4;
        int result = calculator.calculate(x,y);
        System.out.println(result);
    }

    private static Calculator fire(){
        return (x,y) -> x % y ;
    }

    public static void main(String[] args) {
        engine((x,y) -> x + y);
        engine((x,y) -> x - y);
        engine((x,y) -> x * y);
        engine((x,y) -> x / y);

        System.out.println(fire().calculate(2,2));

    }
}
