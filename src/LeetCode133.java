import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    };

    HashMap<Node, Node> map = new HashMap();
    public Node cloneGraph(Node node) {
        return clone(node);
    }

    public Node clone(Node node){

        if(map.containsKey(node)){
            return map.get(node);
        }
        Node clone = new Node(node.val, new ArrayList());
        map.put(node,clone);

        for(Node n:node.neighbors){
            clone.neighbors.add(clone(n));
        }
        return clone;
    }
}
