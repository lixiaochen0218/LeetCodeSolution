public class LeetCode430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    };

    public Node flatten(Node head) {
        if(head == null) return head;
        Node p = head;

        while( p!= null) {
            if( p.child == null ) {
                p = p.next;
                continue;
            }
            Node child = flatten(p.child);
            Node next = p.next;
            p.next = child;
            child.prev = p;
            p.child = null;
            while(child.next != null)
                child=child.next;
            child.next = next;
            if(next != null){
                next.prev = child;
            }
            p = next;
        }
        return head;
    }
}
