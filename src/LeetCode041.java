public class LeetCode041 {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        int aa[] = new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                aa[nums[i] -1] = nums[i];
            }
        }

        for (int i=0;i<aa.length;i++) {
            if (aa[i] != i+1) {
                return i+1;
            }
        }
        return aa.length +1;
    }
}
