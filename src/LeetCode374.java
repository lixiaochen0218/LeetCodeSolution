import java.util.*;

public class LeetCode374 {
    //bucket array
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> ans = new ArrayList();
        HashMap<Integer,Integer> map = new HashMap();
        int maxFre = 1;
        for(int n:nums){
            map.put(n, map.getOrDefault(n,0)+1);
            maxFre = Math.max(maxFre,map.get(n));
        }
        List<Integer>[] bucket = new List[nums.length+1];
        map.forEach((n, fre) -> {
            System.out.format("key: %s, value: %d%n", n, fre);
            if(bucket[fre]==null){
                bucket[fre] = new ArrayList();
            }
            bucket[fre].add(n);
        });
        for(int i=maxFre;i>0;i--){
            if(ans.size()<k){
                if(bucket[i]!=null){
                    ans.addAll(bucket[i]);
                }
            }
        }
        return ans;
    }
    //TreeMap
    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for(int num : map.keySet()){
            int freq = map.get(num);
            if(!freqMap.containsKey(freq)){
                freqMap.put(freq, new LinkedList<>());
            }
            freqMap.get(freq).add(num);
        }

        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res;
    }
}
