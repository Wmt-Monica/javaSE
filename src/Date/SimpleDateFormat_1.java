package Date;

import java.text.*;
import java.util.Date;
/**
 *  DateFormat是一个抽象类，需要用SimpleDateFormat类来实现
 * */
public class SimpleDateFormat_1 {
    public static void main(String[] args) throws ParseException {

        //获取当前时间的方法
        long a1 = System.currentTimeMillis();
        System.out.println("当前时间："+a1);
        //创建SimpleDateFormat 对象，使用格式化方法YYYY年-MM月-DD日 hh时:mm分:ss秒
        SimpleDateFormat time1 = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");

        /**
         *  将时间对象(Date)按照格式转换成字符串
         * */
        Date date1 = new Date();  //不传入参数，默认是当前时间
        //用SimpleDataFormat对象的format()方法将Date对象换成指定样式的字符串
        String str1 = time1.format(date1);
        System.out.println("(不传参数显示当前时间)    str1:"+str1);

        //new Date(ms); 注意：ms:是需要创建的时间和 GMT时间1970年1月1日之间相差的毫秒数；
        // 当前时间与GMT1970.1.1之间的毫秒数：var mills = new Date().getTime();
        Date date4 = new Date(2000);  //2000毫秒等于2秒
        String str2 = time1.format(date4);
        System.out.println("(传入参数，与1970年1月1日 0点0分0秒相差的毫秒数)  str2:"+str2);
        System.out.println(new Date().getTime());
        System.out.println("==================================");

        /**
         *  将字符串转换成Date(时间)对象
         * */
        DateFormat time2 = new SimpleDateFormat("YYYY年MM月dd日 hh时mm分ss秒");
        Date date5 = time2.parse("2019年05月01日 13时32分54秒");
        System.out.println(date5);
    }
}
