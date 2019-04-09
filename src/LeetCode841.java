import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode841 {
    boolean [] all;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int total = rooms.size();
        all = new boolean[total];
        List<Integer> firstKey = new ArrayList();
        firstKey.add(0);
        helper(rooms, firstKey);
        for(boolean boo: all){
            if(!boo) return false;
        }
        return true;

    }

    public void helper(List<List<Integer>> rooms, List<Integer> keys){
        if(keys.size()==0) return;
        for(int i=0;i<keys.size();i++){
            if(all[keys.get(i)]) continue;
            all[keys.get(i)] = true;
            helper(rooms, rooms.get(keys.get(i)));
        }
    }

    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> stack = new Stack();
        stack.push(0);

        while (!stack.isEmpty()) {
            int key = stack.pop();
            for (int k: rooms.get(key))
                if (!seen[k]) {
                    seen[k] = true;
                    stack.push(k);
                }
        }

        for (boolean v: seen)
            if (!v) return false;
        return true;
    }
}
