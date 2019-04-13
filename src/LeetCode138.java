import java.util.HashMap;
import java.util.Map;

public class LeetCode138 {
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node p = head;
        Node p2 = head;
        Map<Node, Node> map = new HashMap();

        while(p != null){
            map.put(p, new Node(p.val,null,null));
            p = p.next;
        }

        while(p2 != null){
            map.get(p2).next = map.get(p2.next);
            map.get(p2).random = map.get(p2.random);
            p2 = p2.next;
        }
        return map.get(head);
    }
}
