package test;

import java.util.LinkedList;
import java.util.List;

public class HanoiRecursion {
    public static void main(String[] args) {
        List<Integer> A = new LinkedList<>();
        List<Integer> B = new LinkedList<>();
        List<Integer> C = new LinkedList<>();
        Solution test = new Solution(A,B,C);
        //A柱子上添加盘子
        for (int i = 5; i >= 1; i--){
            A.add(i);
        }
        test.hanota();
        System.out.println(C);
    }
    static class Solution {
        List<Integer> A,B,C;

        public Solution(List<Integer> a, List<Integer> b, List<Integer> c) {
            A = a;
            B = b;
            C = c;
        }

        public void hanota() {
            int num = A.size();
            func(num,A,B,C);
        }

        public void func (int num, List<Integer> A, List<Integer> B, List<Integer> C){
            //当盘子都搬空了，返回
            if(num <= 0){
                return;
            }
            //1.将A上面的n-1个圆盘经C到B
            func(num - 1, A, C, B);
            //2.将A底下最大的圆盘移动到C柱子中
            C.add(A.remove(A.size()-1));
            //3.最后将B上的n-1圆盘经A移动C上
            func(num-1, B, A, C);
        }
    }
}
