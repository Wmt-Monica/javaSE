package String;

public class TestString {
    public static void main(String[] args) {
        String str = "wmt";
        String str1 = new String("sf");
        String str2 = "wmt"+"sf";
        String str3 = "wmt age is:"+19;  //只要有一个字符串就会以字符串连接符的形式

        String str4 = "WMT";
        String str5 = "WMT";
        String str6 = new String("WMT");

        System.out.println("str4==str5:"+str4==str5);
        System.out.println("str4==str6:"+str4==str6);
    }
}
