/**
 * 字符串是不可变的
 */

public class test {
    public static void main(String[] args) {
        test2();
    }
    private static void test(){

        String str1 = "dharma"; //存在常量池里面
        String str2 = new String("java");  //存在堆里面，也会在常量池里面创建，指针在堆里面
        final String str3 = new String("java");  //存在常量池里面
        String str = str1 + str2; //存在堆里面

        System.out.println(str == str.intern());
        System.out.println(str == "dharmajava");

        String istr= (str1 + str2).intern(); //intern()方法编译的时候不变，运行时强制变成常量
        System.out.println(istr == "dharmajava");

    }

    private static void test2(){
        String str1 = new String("1") + new String("1");

        System.out.println(str1 == str1.intern());
    }
}
