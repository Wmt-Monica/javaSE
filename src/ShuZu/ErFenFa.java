package ShuZu;
/**
 *  二分法排序必须在已经排好序的数组中进行
 *  1.设置好数组的头部(top)和尾部(tail),和中间(middle).middle=(top+tail)/2
 *  2.取中间的数据与所寻找的数据相比较：
 *      1.数据>array[middle]:
 *
 * */
import java.util.Arrays;
import java.util.Scanner;

public class ErFenFa {
    public static void main(String[] args) {
        int[] a = {4,6,78,23,89,56,3,45,9,65,80};
        Arrays.sort(a);  //将数组从下到大排序
        for ( int temp:  a
             ) {
            System.out.print(temp+"\t");
        }
        System.out.print("\n请输入需要查询的数字");
        Scanner t = new Scanner(System.in);
        int date = t.nextInt();
        ErFenFa erFenFa = new ErFenFa();
        erFenFa.Found(date,a);
    }
    int Found(int date, int array[]){
        int top = 0;
        int tail = array.length-1;
        int middle = (top+tail)/2;
        while (top<=tail){
            if (date == array[middle]){
                break;
            }
            if (date > array[middle]){
                top = middle+1;
                middle = (top+tail)/2;
            }
            if (date < array[middle]){
                tail = middle-1;
                middle = (top+tail)/2;
            }
        }
        if (top <= tail){
            System.out.print("该数字排序在第"+(middle+1)+"位");
            return middle;
        }else {
            System.out.println("未查询到该数字");
            return -1;
        }
    }
}
