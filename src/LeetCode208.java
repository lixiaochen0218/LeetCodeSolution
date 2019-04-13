public class LeetCode208 {

    class TrieNode {
        public char val;
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];

        public TrieNode() {
        }

        TrieNode(char c) {
            TrieNode node = new TrieNode();
            node.val = c;
        }
    }

    private TrieNode root;

    public LeetCode208() {
        root = new TrieNode(' ');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode head = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (head.children[c - 'a'] == null) {
                head.children[c - 'a'] = new TrieNode(c);
            }
            head = head.children[c - 'a'];
        }
        head.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode head = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (head.children[c - 'a'] == null) {
                return false;
            }
            head = head.children[c - 'a'];
        }
        return head.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode head = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (head.children[c - 'a'] == null) {
                return false;
            }
            head = head.children[c - 'a'];
        }
        return true;
    }
}
