package homework;

/**
 * 八皇后问题，使用递归的思想完成
 *
 * 思路：
 * 1.第一个皇后先放在第一行第一列
 * 2.第二个皇后放在第二行第二列，然后判断是否OK，如果不OK，继续放在第二列，第三列，一依次把所有列都放完，找到最合适的
 * 3.继续第三个皇后，还是第一列、第二列....直到第八个皇后也能放在不冲突的位置，算是找到了一个正确解
 * 4.当的带了一个正确解时，在栈中退到上一个栈时，即将第一个皇后，放在第一列的所有正确解全部得到
 */
public class EightQueen {
    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.LayUpQueen(0);
        System.out.println("一共有几种摆放方法："+queen.queenLocationNum);
    }

    //创建一个八皇后的类
    static class Queen{
        //1.创建一个一维数组来存储八皇后的位置
        private int[] queenLocation = new int[8];
        int queenLocationNum = 0;

        //2.创建一个输出方法，用于输出放置八皇后位置的正确解
        public void printQueenLocation(){
            for (int i = 0; i < 8; i ++){
                System.out.print(queenLocation[i]+1+" ");
            }
            System.out.println();
        }

        //3.创建判断皇后放在该位置是否发生冲突
        public boolean judgeQueenLocation(int queenNum){
            //遍历所有在之前拍好位置的八皇后的位置进行判断是否冲突
            for (int i = 0; i < queenNum; i++){

                //1.queenLocation[i] == queenLocation[queenNum] 判断是否为同一列
                //2.Math.abs(queenLocation[i] - queenLocation[queenNum]) == Math.abs(i - queenNum) 判断是否为同一对角线
                if (queenLocation[i] == queenLocation[queenNum] ||
                        (Math.abs(queenLocation[i] - queenLocation[queenNum]) == Math.abs(i - queenNum))){
                    return false;
                }
            }
            return true;
        }

        //4.创建一个清除八皇后位置的方法

        //5.创建一个放置八个皇后的方法
        public void LayUpQueen(int queenNum){

            //如果八个皇后已经排好位置了就打印输出吧隔皇后的位置
            if (queenNum == 8){
                queenLocationNum++;
                printQueenLocation();
                return;
            }

            for (int i = 0; i < 8; i ++){
                //依次将皇后的位置从 0 开始 到 7，依次进行判断，直至进行判断不发生冲突
                queenLocation[queenNum] = i;

                //如果这一个皇后的位置与前面的皇后的位置不发生冲突，就继续摆放下一个皇后的位置
                if (judgeQueenLocation(queenNum)){
                    LayUpQueen(queenNum+1);  //如果此处使用LayUpQueen(++queenNum)则会失败？
                }
            }

        }
    }
}
