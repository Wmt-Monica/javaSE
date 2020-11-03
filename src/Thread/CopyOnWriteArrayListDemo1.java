package Thread;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 线程安全：操作并发容器
 */
public class CopyOnWriteArrayListDemo1 {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<>();
        CopyOnWriteArrayList<String> list2 = new CopyOnWriteArrayList<>();
        CopyOnWriteArrayList<String> list3 = new CopyOnWriteArrayList<>();
        CopyOnWriteArrayList<String> list4 = new CopyOnWriteArrayList<>();

        ListName listName1 = new ListName("WMT",list1);
        ListName listName2 = new ListName("SF",list2);
        ListName listName3 = new ListName("wmt",list3);
        ListName listName4 = new ListName("sf",list4);
        new Thread(listName1).start();
        new Thread(listName2).start();
        new Thread(listName3).start();
        new Thread(listName4).start();
        Thread.sleep(1000);
        System.out.println("list1---->"+list1);
        System.out.println("list2---->"+list2);
        System.out.println("list3---->"+list3);
        System.out.println("list4---->"+list4);
    }
}
class ThreadName{
    String name;
    public ThreadName(String name) {
        this.name = name;
    }
}

class ListName implements Runnable{
    ThreadName ThreadNameStep;
    String name;
    CopyOnWriteArrayList<String> list;

    public ListName(String name,CopyOnWriteArrayList<String> list) {
        this.name = name;
        this.list = list;
    }

    @Override
    public void run() {
        for (int i =1; i <= 10; i++){
            String nameStep = name + i;
            this.ThreadNameStep = new ThreadName(nameStep);
//            System.out.println("ThreadNameStep.name---->"+ThreadNameStep.name);
            this.list.add(CopyListName());
        }
    }

    public String CopyListName(){
        return this.ThreadNameStep.name;
    }
}