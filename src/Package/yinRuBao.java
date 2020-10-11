package Package;
import Class.chuanZhiJiZhi;
import static java.lang.Math.*;
import java.util.Date;
import java.sql.*;
public class yinRuBao {
    public static void main(String[] args) {
        /*要使用chuanZhiJiZhi的对象，要先引入chuanZhiJiZhi的包*/
        chuanZhiJiZhi chuan = new chuanZhiJiZhi(19,"wmt");
        chuan.change(19,"wmt");

        /*使用别的包下的对象不用使用点*/
        System.out.println(PI); //直接使用PI,不用Math.PI

        /*当引用不同包相同类的情况下，则在应用的时候使用前缀，避免引用错误*/
        Date date = new Date();  //因为在引用的时候 import java.util.Date;是精确引用，所以使用该包下的类
        java.sql.Date date1 = new java.sql.Date(18);  //当类的名称重名的时候则在调用的时候加上包名称
    }
}
