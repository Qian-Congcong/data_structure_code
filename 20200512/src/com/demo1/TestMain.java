package com.demo1;


import java.util.*;

/**
 * program: 20200512
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-13 11
 * Time:17
 */
public class TestMain {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b);

        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);
    }

    public static void main4(String[] args) {
        Integer a = 10;//自动装箱
        int b = a;//自动拆箱
    }

    public static void main3(String[] args) {//ctil + D 自动复制到下一行
        int i = 10;
        // 装箱操作，新建一个 Integer 类型对象，将 i 的值放入对象的某个属性中
        Integer ii = Integer.valueOf(i);
        Integer ij = new Integer(i);
        // 拆箱操作，将 Integer 对象中的值取出，放到一个基本数据类型中
        int j = ii.intValue();
        double k = ii.doubleValue();

    }

    public static void main2(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("国民女神","高圆圆");
        map.put("国民老公","王思聪");
        map.put("弗拉基米尔公爵","吸血鬼");

        System.out.println(map);
        String s = map.get("国民女神");
        String s2 = map.getOrDefault("国民女神2","江疏影");
        System.out.println(s2);

        System.out.println(map.containsKey("国民老公"));
        System.out.println(map.containsValue("王思聪"));

        System.out.println("=================");

        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Map.Entry<String, String> entry:set) {
            //System.out.println(entry);
            System.out.println(entry.getKey() + "=> " + entry.getValue());
        }
        System.out.println(map.isEmpty());
        map.clear();
        //set.clear();
        System.out.println(map);
        //System.out.println(set);
    }

    public static void main1(String[] args) {
        Collection<String> collection = new ArrayList<>();
        //Collection collection2 = new LinkedList();
        //Collection<Integer> collection2 = new ArrayList<>();
        collection.add("iron man");
        collection.add("java");
        collection.add("phtyon");
        collection.add("c++");
        collection.add("老杨");
        System.out.println(collection);
        System.out.println("===================");
        for (String s: collection) {
            System.out.println(s);
        }
        /*collection.clear();
        System.out.println(collection);*/
        System.out.println(collection.isEmpty());
        collection.remove("java");
        System.out.println(collection);
        System.out.println(collection.size());

        Object[] objects = collection.toArray();
        System.out.println(Arrays.toString(objects));
        for (Object s: objects) {
            System.out.println(s);
        }

    }
}
