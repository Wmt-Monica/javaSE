package Collection;

import java.util.*;

/**
 * 将一个表格数据放入容器当中去
 * 方法：将一行的数据放入一个容器当中去，再将每一个装行元素的容器放入另一个容器当中去
 */
public class tableDemo {
    public static void main(String[] args) {

        //使用Map容器存放行元素
        Map<String,Object> map1 = new HashMap<>();
        map1.put("employId",1001);
        map1.put("name","王梦婷");
        map1.put("job_kind","Java开发工程师");
        map1.put("age",20);
        map1.put("salary",20000);

        Map<String,Object> map2 = new HashMap<>();
        map2.put("employId",1002);
        map2.put("name","王梦婷");
        map2.put("job_kind","Java开发工程师");
        map2.put("age",21);
        map2.put("salary",22000);

        Map<String,Object> map3 = new HashMap<>();
        map3.put("employId",1003);
        map3.put("name","王梦婷");
        map3.put("job_kind","Java开发工程师");
        map3.put("age",22);
        map3.put("salary",25000);

        //使用List容器将存放行元素的容器存放
        List<Map<String,Object>> listTable = new ArrayList<>();
        listTable.add(map1);
        listTable.add(map2);
        listTable.add(map3);

        //遍历行元素，不止一行的元素
        for (Map<String, Object> row : listTable){
            //key容器
            Set<String> keySet = row.keySet();

            //遍历列元素
            for (String key : keySet){
                System.out.print(key+":"+ row.get(key)+"\t");
            }
            System.out.println();
        }
    }
}
