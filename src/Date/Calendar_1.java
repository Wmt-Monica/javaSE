package Date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 *  Java中月份是从0开始存入的数组
 *  星期是从星期日开始第一个星期，星期六时第七个星期
 * */
public class Calendar_1 {
    public static void main(String[] args) {
        /*Calendar抽象类，创建GregorianCalendar对象获取日期元素
            语法：Calendar对象.get(Calendar.(获取日期元素大写))
        */
        Calendar calendar = new GregorianCalendar();
        System.out.println(calendar);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println("year:"+year+"\tmonth:"+(month+1)+"\tday:"+day+"\tweek:"+week);

        //设置日历元素set()方法
        Calendar calendar1 = new GregorianCalendar();
        calendar1.set(Calendar.YEAR,2001);
        System.out.println("calendar1.year:"+calendar1.get(Calendar.YEAR));

        //计算日历元素add()方法
        Calendar calendar2 = new GregorianCalendar();
        calendar2.set(Calendar.DATE,29);  //用set()设置日的数值
        calendar2.add(Calendar.DATE,5);  //用add()在设置日期数值添加5天后的日期
        System.out.println("calendar2.date:"+calendar2.get(Calendar.DATE));  //用get()输出日期元素

        /*
            日期对象和时间对象的转换
                日期转换成时间用getTime()方法
                时间转换成日期用setTime()方法
        */
        Calendar calendar3 = new GregorianCalendar();
        Date date;
        date = calendar3.getTime();  //用getTime()方法用于将Calender对象calender3转换成Date对象
        calendar3.setTime(date);  //用setTime()方法将Date对象date转换成Calender对象calender3
    }
}
