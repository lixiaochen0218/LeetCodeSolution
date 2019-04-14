public class LeetCode211 {
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }

    private TrieNode root = new TrieNode();

    /** Initialize your data structure here. */
    public LeetCode211() {

    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode head = root;
        for(char c: word.toCharArray()){
            if(head.children[c - 'a'] == null){
                head.children[c - 'a'] = new TrieNode();
                // head.item = c + "";
            }
            head = head.children[c - 'a'];
        }
        head.item = word;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(word.toCharArray(), 0, root);
    }

    public boolean helper(char[] letters, int index, TrieNode head){
        if(index == letters.length) return !head.item.equals("");
        if(letters[index] != '.'){
            return head.children[letters[index] - 'a'] != null && helper(letters, index+1,head.children[letters[index] - 'a']);
        }else{
            for(int i=0;i<head.children.length;i++){
                if(head.children[i] != null){
                    if(helper(letters, index+1,head.children[i])){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
