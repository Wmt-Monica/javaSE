package Class;

public class thisObject {
    int a,b,c,d;
    public thisObject(int a,int b){
        this.a=a;
        this.b=b;
        System.out.println("先执行static语句块中的语句");
        System.out.println("static修饰的方法和变量属于类，而其他的普通方法和变量属于对象");
        System.out.println("程序在运行时，先加载类，在加载对象，故因此这里static语句块中的语句先执行");
    }
    public thisObject(int a,int b,int c){
        this(a,b);  //引用同名的构造方法时，使用this即可
        this.c=c;
    }
    static void thisObject(int a,int b,int c,int d){
        //this不能用于static方法中
    }
    static {
        System.out.println("此为static语句块");
        System.out.println("=======================================");
    }
    public static void main(String[] args) {
        thisObject  object = new thisObject(3,4);
    }
}

