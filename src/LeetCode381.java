import java.util.*;

public class LeetCode381 {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random random = new Random();

    /** Initialize your data structure here. */
    public LeetCode381() {

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val, new HashSet());
        }
        map.get(val).add(list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        if(!map.get(val).contains(list.size()-1)){
            int currPos = map.get(val).iterator().next();
            int lastVal = list.get(list.size() - 1);
            map.get(lastVal).remove(list.size() - 1);
            map.get(lastVal).add(currPos);
            map.get(val).remove(currPos);
            map.get(val).add(list.size() - 1);
            list.set(currPos, lastVal);

        }
        map.get(val).remove(list.size()-1);
        if(map.get(val).isEmpty()) map.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}