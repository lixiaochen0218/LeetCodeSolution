public class LeetCode117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        Node parent = root;
        Node childHead =  null;
        Node child = null;

        while(parent != null) {
            while(parent != null) {
                if (parent.left!= null) {
                    if (childHead != null) {
                        child.next = parent.left;
                        child = parent.left;
                    } else {
                        childHead = parent.left;
                        child = parent.left;
                    }
                }

                if (parent.right!= null) {
                    if (childHead != null) {
                        child.next = parent.right;
                        child = parent.right;
                    } else {
                        childHead = parent.right;
                        child = parent.right;
                    }
                }

                parent = parent.next;
            }
            parent = childHead;
            child = null;
            childHead = null;
        }

        return root;
    }
}
