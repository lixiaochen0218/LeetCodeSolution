public class LeetCode081 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int start = 0;
        int end = nums.length -1;

        while(end - start > 1){
            int mid = start + (end - start)/2;
            if (nums[mid] == target )
                return true;
            if(nums[start] == nums[mid]){
                start++;
                continue;
            }
            if(nums[end] == nums[mid]){
                end--;
                continue;
            }
            if (nums[start] < nums[mid]){
                if (target >= nums[start] && target <= nums[mid]) end = mid;
                else start = mid;
            } else if(nums[mid] < nums [end]) {
                if (target >= nums[mid] && target <= nums[end]) start = mid;
                else end = mid;
            }
        }
        if (nums[start] == target) return true;
        if (nums[end] == target) return true;
        return false;
    }
}
