package ShuZu;
/**
 *  数组存储表格数据
 * */
import java.util.Arrays;

public class TableDate {
    public static void main(String[] args) {
        Object[] temp1 = {19,"wmt","B190108",000101621};
        Object[] temp2 = {20,"sf","B200113",000101722};
        Object[] temp3 = {21,"DWH","B170321",000200131};
        Object[][] tempAll = new Object[3][];
        tempAll[0] = temp1;
        tempAll[1] = temp2;
        tempAll[2] = temp3;
        for ( Object[] a : tempAll
             ) {
            System.out.println(Arrays.toString(a));  //使用Array.toString()方法是专门打印数组，集合
        }
    }
}
