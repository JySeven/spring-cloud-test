package ThreadTest;

import java.util.LinkedHashMap;

public class Test {

    public static void main(String[] args) {
        final int max= 5;
        LinkedHashMap<Integer,String> linkedHashMap=new LinkedHashMap<Integer, String>(){
//            @Override
//            protected boolean removeEldestEntry(Entry<Integer, String> eldest) {
//                return super.removeEldestEntry(eldest);
//            }
        };
        linkedHashMap.put(1,"1");
        linkedHashMap.put(2,"2");
        linkedHashMap.put(3,"3");
        linkedHashMap.put(4,"4");
        linkedHashMap.put(5,"5");
        System.out.println(linkedHashMap);
        linkedHashMap.put(6,"6");
        System.out.println(linkedHashMap);
        linkedHashMap.put(7,"7");
        System.out.println(linkedHashMap);


    }

}
