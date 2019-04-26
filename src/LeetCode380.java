import java.util.*;

public class LeetCode380 {
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    Random rnd = new Random();

    /** Initialize your data structure here. */
    public LeetCode380() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val,list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int idx = map.remove(val);
        int last = list.remove(list.size() - 1);
        if(val != last) {
            list.set(idx, last);
            map.put(last, idx);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rnd.nextInt(list.size()));
    }
}
