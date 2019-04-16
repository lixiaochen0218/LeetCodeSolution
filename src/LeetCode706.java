public class LeetCode706 {
    final ListNode[] nodes = new ListNode[10000];

    /** Initialize your data structure here. */
    public LeetCode706() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int i = idx(key);
        if(nodes[i] == null){
            nodes[i] = new ListNode(-1,-1);
        }
        ListNode prev = findPrev(nodes[i], key);
        if (prev.next == null){
            prev.next = new ListNode(key, value);
        }else{
            prev.next.val = value;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int i = idx(key);
        if (nodes[i] == null)
            return -1;
        ListNode prev = findPrev(nodes[i], key);
        return prev.next == null ? -1 : prev.next.val;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = idx(key);
        if (nodes[i] == null)
            return;
        ListNode prev = findPrev(nodes[i], key);
        if(prev.next != null && prev.next.key == key){
            prev.next = prev.next.next;
        }else{
            return;
        }
    }

    class ListNode {
        int key, val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int idx(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    private ListNode findPrev(ListNode bucket, int key) {
        ListNode node = bucket, prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }
}
