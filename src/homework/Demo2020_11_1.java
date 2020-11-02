package homework;

/**
 * 使用递归完成计算阶层的课堂作业
 */
public class Demo2020_11_1 {
    public static void main(String[] args) {
        System.out.println(JieCen(5));

        int num = 5;
        int step = 1;
        for (int i = 1; i <= num; i ++){
            step *= i;
        }
        System.out.println(num+"的阶层为："+step);
    }

    public static int JieCen(int num){
        if (num == 1){
            return num;
        }else {
            return num*JieCen(num-1);
        }
    }
}
