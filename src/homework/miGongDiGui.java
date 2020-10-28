package homework;

/**
 * 使用递归实现迷宫的最短距离
 * 0:表示可走的未走的路
 * 1.表示墙或者障碍物
 * 2.表示已经走过的路
 * 3.表示已经走过判定死路
 */
public class miGongDiGui {
    public static void main(String[] args) {

        int[][] map = new int[10][10];

        for (int t = 0; t < 10; t++){

            //一：制作地图
            for (int i = 0; i < 10; i++){
                for (int j = 0; j < 10; j++){
                    map[i][j] = 0;
                    if (i == 0 || i == 9 || j == 0 || j == 9){
                        map[i][j] = 1;
                    }
                }
            }

            //二：填充地图的障碍物
            map[2][3] = 1;
            map[3][1] = 1;
            map[3][2] = 1;
            map[3][3] = 1;
            map[4][3] = 1;
            map[4][4] = 1;
            map[4][5] = 1;
            map[4][6] = 1;
            map[4][7] = 1;
            map[5][6] = 1;
            map[5][7] = 1;
            map[6][4] = 1;
            map[6][5] = 1;
            map[6][6] = 1;
            map[7][4] = 1;

            int[][] temp = map;

            switch (t){
                case 0: MiGong1(temp,1,1);
                case 1: MiGong2(temp,1,1);
                case 2: MiGong3(temp,1,1);
                case 3: MiGong4(temp,1,1);
                case 4: MiGong5(temp,1,1);
                case 5: MiGong6(temp,1,1);
                case 6: MiGong7(temp,1,1);
                case 7: MiGong8(temp,1,1);
            }
        }

        //通过记录好的所有走法的步数，找到最少步数，并记录好其下标 mark
        int min = jie[0];
        int mark = 0;
        for (int i = 1 ; i < 8 ; i++){
            if (jie[i] < min){
                min = jie[i];
                mark = i;
            }
        }

        switch (mark){
            case 0: MiGong1(map,1,1);
            case 1: MiGong2(map,1,1);
            case 2: MiGong3(map,1,1);
            case 3: MiGong4(map,1,1);
            case 4: MiGong5(map,1,1);
            case 5: MiGong6(map,1,1);
            case 6: MiGong7(map,1,1);
            case 7: MiGong8(map,1,1);
        }

        for (int i = 0; i < 10; i++){
            for (int j = 0;j < 10; j++){
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println("最少的步数为："+jie[mark]);

    }

    static int[] jie = new int[8];
    static int count = 0;

    //走法一：下->右->上->左
    public static boolean MiGong1(int[][] map, int i, int j){
        if (map[8][8] == 2){
            jie[0] = count;
            count = 0;
           return true;
        }else {
            if (map[i][j] == 0){
                count++;
                map[i][j] = 2;
                if (MiGong1(map,i+1,j)){  //向下
                    return true;
                }else if (MiGong1(map,i,j+1)){  //向右
                    return true;
                }else if (MiGong1(map,i-1,j)){  //向上
                    return true;
                }else if (MiGong1(map,i,j-1)){  //向左
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }

    //走法二：下->左->上->右
    public static boolean MiGong2(int[][] map, int i, int j){
        if (map[8][8] == 2){
            jie[1] = count;
            count = 0;
            return true;
        }else {
            if (map[i][j] == 0){
                count++;
                map[i][j] = 2;
                if (MiGong2(map,i+1,j)){  //向下
                    return true;
                }else if (MiGong2(map,i,j-1)){  //向左
                    return true;
                }else if (MiGong2(map,i-1,j)){  //向上
                    return true;
                }else if (MiGong2(map,i,j+1)){  //向右
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }

    //走法三：上->左->下->右
    public static boolean MiGong3(int[][] map, int i, int j){
        if (map[8][8] == 2){
            jie[2] = count;
            count = 0;
            return true;
        }else {
            if (map[i][j] == 0){
                count++;
                map[i][j] = 2;
                if (MiGong3(map,i-1,j)){  //向上
                    return true;
                }else if (MiGong3(map,i,j-1)){  //向左
                    return true;
                }else if (MiGong3(map,i+1,j)){  //向下
                    return true;
                }else if (MiGong3(map,i,j+1)){  //向右
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }

    //走法四：上->右->下->左
    public static boolean MiGong4(int[][] map, int i, int j){
        if (map[8][8] == 2){
            jie[3] = count;
            count = 0;
            return true;
        }else {
            if (map[i][j] == 0){
                count++;
                map[i][j] = 2;
                if (MiGong4(map,i-1,j)){  //向上
                    return true;
                }else if (MiGong4(map,i,j+1)){  //向右
                    return true;
                }else if (MiGong4(map,i+1,j)){  //向下
                    return true;
                }else if (MiGong4(map,i,j-1)){  //向左
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }

    //走法五：左->上->右->下
    public static boolean MiGong5(int[][] map, int i, int j){
        if (map[8][8] == 2){
            jie[4] = count;
            count = 0;
            return true;
        }else {
            if (map[i][j] == 0){
                count++;
                map[i][j] = 2;
                if (MiGong5(map,i,j-1)){  //向左
                    return true;
                }else if (MiGong5(map,i-1,j)){  //向上
                    return true;
                }else if (MiGong5(map,i,j+1)){  //向右
                    return true;
                }else if (MiGong5(map,i+1,j)){  //向下
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }

    //走法六：左->下->右->上
    public static boolean MiGong6(int[][] map, int i, int j){
        if (map[8][8] == 2){
            jie[5] = count;
            count = 0;
            return true;
        }else {
            if (map[i][j] == 0){
                count++;
                map[i][j] = 2;
                if (MiGong6(map,i,j-1)){  //向左
                    return true;
                }else if (MiGong6(map,i+1,j)){  //向下
                    return true;
                }else if (MiGong6(map,i,j+1)){  //向右
                    return true;
                }else if (MiGong6(map,i-1,j)){  //向上
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }

    //走法七：右->下->左->上
    public static boolean MiGong7(int[][] map, int i, int j){
        if (map[8][8] == 2){
            jie[6] = count;
            count = 0;
            return true;
        }else {
            if (map[i][j] == 0){
                count++;
                map[i][j] = 2;
                if (MiGong7(map,i,j+1)){  //向右
                    return true;
                }else if (MiGong7(map,i+1,j)){  //向下
                    return true;
                }else if (MiGong7(map,i,j-1)){  //向左
                    return true;
                }else if (MiGong7(map,i-1,j)){  //向上
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }

    //走法八：右->上->左->下
    public static boolean MiGong8(int[][] map, int i, int j){
        if (map[8][8] == 2){
            jie[7] = count;
            count = 0;
            return true;
        }else {
            if (map[i][j] == 0){
                count++;
                map[i][j] = 2;
                if (MiGong8(map,i,j+1)){  //向右
                    return true;
                }else if (MiGong8(map,i-1,j)){  //向上
                    return true;
                }else if (MiGong8(map,i,j-1)){  //向左
                    return true;
                }else if (MiGong8(map,i+1,j)){  //向下
                    return true;
                }else {
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
