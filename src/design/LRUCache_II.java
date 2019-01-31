package design;

import java.util.LinkedHashMap;

class LRUCache_II {
    
    private final int CAPACITY;
    
    private final LinkedHashMap<Integer, Integer> CACHE;

    public LRUCache_II(int capacity) {
        this.CAPACITY = capacity;
        this.CACHE = new LinkedHashMap<Integer, Integer>();
    }
    
    public int get(int key) {
        if (this.CACHE.containsKey(key)) {
            int value = this.CACHE.get(key);
            this.CACHE.remove(key);
            this.CACHE.put(key, value);
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (this.CACHE.containsKey(key)) {
            this.CACHE.remove(key);
            this.CACHE.put(key, value);
        } else {
            if (this.CACHE.size() >= CAPACITY) {
                this.CACHE.remove(this.CACHE.keySet().iterator().next());
            }
            this.CACHE.put(key, value);
        }
    }
}
