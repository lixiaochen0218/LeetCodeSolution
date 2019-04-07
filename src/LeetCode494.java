public class LeetCode494 {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return ans;
        helper(0, 0, S, nums);
        return ans;
    }

    private void helper(int index, int sum, int S, int[] nums){
        if(index == nums.length ){
            if(sum == S){
                ans++;
            }
            return;
        }
        helper(index+1,sum-nums[index],S,nums);
        helper(index+1,sum+nums[index],S,nums);
    }
}
