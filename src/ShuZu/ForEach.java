package ShuZu;

public class ForEach {
    public static void main(String[] args) {
       User2[] user2s = new User2[2];
       user2s[0] = new User2(19,"WMT");
       user2s[1] = new User2(21,"SF");
        for (User2 user:user2s
             ) {
                System.out.println("age:"+user.setAge()+"\tname:"+user.setName());
        }
    }
}
class User2{
    private int age;
    private String name;

    public int setAge() {
       return age;
    }

    public String  setName() {
       return name;
    }
    User2(int age , String name){
        this.age = age;
        this.name = name;
    }
}