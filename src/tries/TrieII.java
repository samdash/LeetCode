package tries;

class TrieNodeI {
    // Initialize your data structure here.
    public TrieNodeI[] children;
    public boolean isWord;
    public TrieNodeI() {
        children = new TrieNodeI[26];    
    }
}

public class TrieII {
    private TrieNodeI root;
    private boolean startWith;

    public TrieII() {
        root = new TrieNodeI();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        insert(word,root,0);
    }
    
    private void insert(String word, TrieNodeI root, int idx){
        if(idx==word.length()){
            root.isWord=true;
            return;
        }
        int index = word.charAt(idx)-'a';
        if(root.children[index]==null)
            root.children[index]=new TrieNodeI();
        insert(word, root.children[index], idx+1);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return search(word, root, 0);         
    }
    
    public boolean search(String word, TrieNodeI root, int idx){
        if(idx==word.length()) {
            startWith = true;
            return root.isWord;
        }
        int index = word.charAt(idx)-'a';
        if(root.children[index]==null) {
            startWith = false;
            return false;
        }
            
        return  search(word,root.children[index],idx+1);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        search(prefix);
        return startWith;
    }
}