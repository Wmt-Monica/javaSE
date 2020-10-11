package object;

public class equals {
    public static void main(String[] args) {
        Users user1 = new Users();
        Users user2 = new Users();
        user1.age=19;
        user2.age=19;
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user1.equals(user2));
        System.out.println(user1==user2);
    }
}
class Users{
    String name;
    int age;

    @Override
    public boolean equals(Object object){
        Users users = (Users) object;
        if (((Users) object).age!=users.age)
            return false;
        return true;
    }
}

