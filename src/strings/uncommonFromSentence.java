package strings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class uncommonFromSentence {

	public static void main(String[] args) {
		uncommonFromSentence s = new uncommonFromSentence();
		System.out.println(s.uncommonFromSentences("this is a long sentence", "this is a bigger sentence").toString());
	}

    public List<String> uncommonFromSentences(String A, String B) {
    	
    	HashMap<String, Integer> data = new HashMap<String,Integer>();
    	String[] s = (A +" "+B).split(" ");
    	for(int i=0;i<s.length;i++) {
    		 if(data.containsKey(s[i])) {
    			 data.put(s[i], data.get(s[i]) +1);
    		 }else {
    			 data.put(s[i], 1);
    		 }
    	}
    	
    	List<String> list = new ArrayList<String>();
    	for (Map.Entry<String, Integer> entry : data.entrySet()) {
    	    String key = entry.getKey();
    	    Integer value = (Integer)entry.getValue();
    	    System.out.println("key: "+key+" value: "+value);
    	    if(value.intValue() == 1) list.add(key); 
    	}
    	
    	return list;
    }
    
	 
}
