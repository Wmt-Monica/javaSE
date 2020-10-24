package Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 列元素的存储使用一个User类对象来存储
 */
public class tableDemo2 {
    public static void main(String[] args) {
        User user1 = new User(1001,"王梦婷","Java开发工程师",21000,20);
        User user2 = new User(1002,"王梦婷","Java开发工程师",22000,21);
        User user3 = new User(1003,"王梦婷","Java开发工程师",23000,22);
        User user4 = new User(1004,"王梦婷","Java开发工程师",25000,23);

        //创建List容器存放列元素
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        //打印表格
        for (User user : list){
            System.out.println(user);
        }

        //创建Map容器存放容器
        Map<Integer,User> map = new HashMap<>();
        map.put(1001,user1);
        map.put(1002,user2);
        map.put(1003,user3);
        map.put(1004,user4);

        //打印表格
        for (int key : map.keySet()){
            System.out.println(key+"----"+map.get(key));
        }
    }

    static class User{
        private int job_id;
        private String name;
        private String job_kind;
        private int salary;
        private int age;

        //无参构造器
        public User(){

        }

        //有参构造器
        public User(int job_id, String name, String job_kind, int salary, int age) {
            this.job_id = job_id;
            this.name = name;
            this.job_kind = job_kind;
            this.salary = salary;
            this.age = age;
        }

        //重写toString()方法
        @Override
        public String toString() {
            return "User{" +
                    "job_id=" + job_id +
                    ", name='" + name + '\'' +
                    ", job_kind='" + job_kind + '\'' +
                    ", salary=" + salary +
                    ", age=" + age +
                    '}';
        }

        public int getJob_id() {
            return job_id;
        }

        public void setJob_id(int job_id) {
            this.job_id = job_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getJob_kind() {
            return job_kind;
        }

        public void setJob_kind(String job_kind) {
            this.job_kind = job_kind;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
