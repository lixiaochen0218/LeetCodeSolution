import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        // Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(Integer n : nums1){
            if (binarySearch(nums2, n)){
                System.out.println(n);
                set.add(n);
            }
        }
        int[] results = new int[set.size()];
        int i = 0;
        for (Integer n: set)
            results[i++] = n;
        return results;
    }

    public boolean binarySearch(int[] nums, int target){
        // System.out.println(target);
        int start = 0;
        int end =nums.length -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }else if(nums[mid]>target){
                end = mid -1;
            }else{
                start = mid + 1;
            }

        }
        return false;
    }
}
