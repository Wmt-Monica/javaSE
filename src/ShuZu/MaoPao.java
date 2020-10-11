package ShuZu;

public class MaoPao {
    public static void main(String[] args) {
        int[] a = {5,3,8,0,2,4,1,7,9,6};
        for(int i=0;i<a.length;i++){
            boolean flag = true;
            for (int j=0;j<(a.length-1-i);j++){
                if (a[j]>a[j+1]){
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t;
                    flag = false;
                }
            }
            if (flag){
                System.out.println("排序了"+i+"次，结束排序，排序结果如下：");
                break;
            }
        }
        for (int t: a
             ) {
            System.out.print(t+"\t");
        }
    }
}
