package object;

public class FuStatic {
    static {
        System.out.println("调用父类的静态语句块");
    }
    FuStatic(){
        System.out.println("调用父类的构造方法");
    }
    public static void main(String[] args) {
        ZiLei ziLei = new ZiLei();
    }
}

class ZiLei extends FuStatic{
    void FuStatic(){
        System.out.println("子类无法重写父类的构造器，这个是属于子类新的方法体");
    }
    ZiLei(){
        super();  //调用父类的构造方法，即使不写，默认也会在子类构造方法的第一句
    }
}

/** 修饰符：访问权限
 *  private:同一类
 *  default:同一类，同一包
 *  protected:同一类，同一包，子类（不同包的子类）
 *  public:同一类，同一包，子类，所有类型
 */

class MoRenLei{ //（default属性）
    static {
        System.out.println("当类没有修饰符修饰的时候默认是只有本包下的可以引用（default属性）");
    }
}
