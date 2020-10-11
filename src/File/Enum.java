package File;


/**
 *  枚举的使用
 */
public class Enum {
    public static void main(String[] args) {
        Season season = Season.SPRING;
        switch (season){
            case SPRING:System.out.println("春天");break;
            case SUMMER:System.out.println("夏天");break;
            case AUTUMN:System.out.println("秋天");break;
            case WINTER:System.out.println("冬天");break;
        }
    }
    /**定义一个季节的枚举，里面存放着春夏秋冬四个常量，枚举的作用在于方便便捷，
     用于存放常量，如果要使用枚举的高级方法这建议直接创建一个类*/
    enum Season{
        SPRING,SUMMER,AUTUMN,WINTER
    }
}
