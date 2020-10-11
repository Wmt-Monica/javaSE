package String;

public class TestString2 {
    public static void main(String[] args) {
        //静态创建字符串对象
        String s1 = new String("wmt");
        //用字符数组创建字符串对象
        char[] str = {'w','m','t','s','f'};

        String s2 = new String(str);
        System.out.println("s1:"+s1+"\ts2:"+s2);

        //连接字符串str1.concat(str2)
        System.out.println("s1+s2："+s1.concat(s2));

        String s3 = "WMT"+"SF";
        String s4 = "WMTSF";
        System.out.println("s3==s4: "+s3==s4);

    }
}
