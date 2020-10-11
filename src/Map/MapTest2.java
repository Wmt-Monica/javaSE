package Map;

import java.util.HashMap;
import java.util.Map;

public class MapTest2 {
    static class MapObject{
        String name;
        int age;
        int id;

        public MapObject(int id,String name,int age){
            this.id = id;
            this.name = name;
            this.age = age;
        }

    }
    public static void main(String[] args) {
        MapObject obj1 = new MapObject(1,"wmt1",18);
        MapObject obj2 = new MapObject(2,"wmt2",19);
        MapObject obj3 = new MapObject(3,"wmt3",20);
        MapObject obj4 = new MapObject(4,"wmt4",21);

        Map<Integer,MapObject> map = new HashMap<>();
        map.put(1001,obj1);
        map.put(1002,obj2);
        map.put(1003,obj3);
        map.put(1004,obj4);

        System.out.println(map);
        System.out.println("键为1002的数据："+map.get(1002));
        map.put(1002,obj4);
        System.out.println("键为1002的数据："+map.get(1002));

    }
}
