package Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class RiLi_1 {
    public static void main(String[] args) throws ParseException {
        System.out.println("请输入日期：格式(2020-10-8)");
        Scanner RiQiStep = new Scanner(System.in);
        String RiQi = RiQiStep.nextLine();
        System.out.println(RiQi);
        DateFormat a1 = new SimpleDateFormat("YYYY-MM-dd");  //定义日期格式
        Date date = a1.parse(RiQi);  //将字符串转换成Date类
        String a2 = date.toString();
        System.out.println(a2);
        Calendar calendar = new GregorianCalendar();  //创建日期类
        calendar.setTime(date);
        System.out.print(calendar.get(Calendar.YEAR)+"-");
        System.out.print(calendar.get(Calendar.MONTH)+"-");
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        calendar.setTime(date);  //将由字符串转换后的Date类给日历类对象
        System.out.println("日\t\t一\t\t二\t\t三\t\t四\t\t五\t\t六");
        int day =calendar.get(Calendar.DAY_OF_MONTH);  //记录当天在这个月的几号
        calendar.set(Calendar.DAY_OF_MONTH,1);  //将日期类的头一天设置为1号开始
        for (int i = 0 ; i!= calendar.get(Calendar.DAY_OF_WEEK); i++){
            System.out.print("\t\t");
        }
        //calendar.getActualMaximum(Calendar.DAY_OF_MONTH)是获取这个月一共有多少天
        int dayMAX = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1 ; i <= dayMAX; i++){
            if (calendar.get(Calendar.DAY_OF_WEEK)==7){
                System.out.println();
            }
            if (i == day) System.out.print("*");
            System.out.print(calendar.get(Calendar.DAY_OF_MONTH)+"\t\t");
            calendar.add(Calendar.DAY_OF_MONTH,1);
        }
    }
}
