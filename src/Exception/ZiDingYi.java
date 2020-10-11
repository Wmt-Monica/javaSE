package Exception;

public class ZiDingYi {
    public static void main(String[] args) throws ageException2 {
        int age = -10;
        if (age<0||age>150){
            try {
                throw new ageException();
            }catch (ageException e){
                e.printStackTrace();
            }
        }
        int age2 = -20;
        if (age2<0||age2>150){
            //当自定义异常不是RuntimeException时，不是运行时异常不能直接抛出，
            // 可以采用try,catch,或者调用异常的方法抛出该异常
            throw new ageException2();
        }
    }
    /**
     *  自定义异常需要自定义的异常子类继承相应的异常父类
     */
    static class ageException extends RuntimeException{
        public void ageException(int age){
            if (age <= 0||age >=150){
                System.out.println("年龄输入错误");
            }
        }
    }
    static class ageException2 extends Exception{
        public void ageException(int age){
            if (age <= 0||age >=150){
                System.out.println("年龄输入错误");
            }
        }
    }
}
