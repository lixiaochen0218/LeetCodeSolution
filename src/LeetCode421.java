public class LeetCode421 {
    public int findMaximumXOR(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j ++){
                result = Math.max(result, nums[i] ^ nums[j]);
            }
        }
        return result;
    }
}
