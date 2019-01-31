package tries;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode());
        }
        current.setEndOfWord(true);
    }

    public void insertII(String word) {
    	TrieNode current = root;
    	
    	for(int i=0;i< word.length() ; i ++) {
    		char c = word.charAt(i);
    		if(current.getChildren().get(c) == null) {
    			current.getChildren().put(c, new TrieNode());
    		}
    		current = current.getChildren().get(c);
    	}
    	current.setEndOfWord(true);
    }
    
    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }
    
    public boolean containsNode(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    public boolean isEmpty() {
        return root == null;
    }

     
    /* Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char key = word.charAt(i);
            TrieNode node = current.getChildren().get(key);
            //if node does not exist for given char then return false
            if (node == null) {
                return false;
            }
            current = node;
        }
        //return true of current's endOfWord is true else return false.
        return current.isEndOfWord();
    }
    
    /* Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char key = word.charAt(i);
            TrieNode node = current.getChildren().get(key);
            //if any prefix node doesn't exist that means word doesn't start with that prefix
            //so returning false immediately
            if (node == null) {
                return false;
            }
            current = node;
        }
        //Returning true as all nodes are found as prefix
        return true;
    }
    
    public static void main(String[] s ) {
    	Trie obj = new Trie();
    	String word = "sam";
    	obj.insert(word);
    	boolean param_2 = obj.search(word);
    	boolean param_3 = obj.startsWith("s");
    	System.out.println(param_2 + " : "+param_3);
    }
    
    
    
}