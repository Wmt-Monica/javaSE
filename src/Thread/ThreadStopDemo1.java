package Thread;

/**
 * 终止线程：
 *      1.线程正常执行完毕--->次数
 *      2.外部干涉--->加入标识
 *      3.不要使用stop()方法 destroy (不安全)
 */
public class ThreadStopDemo1 {
    public static void main(String[] args) {
        StopLei stop = new StopLei("SF");
        new Thread(stop).start();
        while (stop.flag == true){
            System.out.println("==============="+stop.i+"===============");
        }
    }
}

class StopLei implements Runnable{

    String name;
    int i;
    boolean flag = true;

    public StopLei(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (flag == true){
            System.out.println(this.name+"--->"+this.i++);
            if (this.i == 66){
                stop();
            }
        }
    }

    public void stop(){
        this.flag = false;
    }
}