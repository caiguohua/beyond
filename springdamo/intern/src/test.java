/**
 * �ַ����ǲ��ɱ��
 */

public class test {
    public static void main(String[] args) {
        test2();
    }
    private static void test(){

        String str1 = "dharma"; //���ڳ���������
        String str2 = new String("java");  //���ڶ����棬Ҳ���ڳ��������洴����ָ���ڶ�����
        final String str3 = new String("java");  //���ڳ���������
        String str = str1 + str2; //���ڶ�����

        System.out.println(str == str.intern());
        System.out.println(str == "dharmajava");

        String istr= (str1 + str2).intern(); //intern()���������ʱ�򲻱䣬����ʱǿ�Ʊ�ɳ���
        System.out.println(istr == "dharmajava");

    }

    private static void test2(){
        String str1 = new String("1") + new String("1");

        System.out.println(str1 == str1.intern());
    }
}
