package Thread;

/**
 * volatile 用于保证数据的同步，也就是可见性
 *      可见性：简单地说就时当线程A对变量X进行了修改后，
 *             在线程A后面执行的其他线程就能看见变量X的变动，
 *             更详细地说就是要符合以下两个规则：
 *               1）：线程对变量修改之后，就立刻回写到主内存
 *               2）：线程对变量读取地时候，要从主内存中读取，而不是缓存
 * 注意：volatile是不错地机制，但是不能保证原子性，并且现在虚拟机地性能比较好，
 *       如果不是频繁地操作，数据一般都能保证得到最新地数据
 *
 */
public class VolatileDemo1 {
    volatile static int value = 0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (value == 0){
                //注意为了避免现虚拟机会优先启动某个线程起到优化作用，我们再while语句里面不写任何语句
            }
        }).start();

        Thread.sleep(1000);
        value = 1;
    }
}
