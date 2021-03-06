package design;

import java.util.LinkedHashMap;
import java.util.Map;


class LRUCache_I {

     private LinkedHashMap<Integer, Integer> map;
     private final int CAPACITY;
     @SuppressWarnings("serial")
	public LRUCache_I(int capacity) {
         CAPACITY = capacity;
         map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
             protected boolean removeEldestEntry(Map.Entry eldest) {
                 return size() > CAPACITY;
             }
         };
     }
     public int get(int key) {
         return map.getOrDefault(key, -1);
     }
     public void put(int key, int value) {
         map.put(key, value);
     }
}