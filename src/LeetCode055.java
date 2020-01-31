public class LeetCode055 {
    public boolean canJump(int[] nums) {
        // return helper(nums, 0);
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    private boolean helper(int[] nums, int index){
        if (index == nums.length -1) {
            return true;
        } else {
            int max = Math.min(index + nums[index], nums.length -1);
            for (int i=max;i>index; i-- ){
                if (helper(nums, i)) {
                    return true;
                }
            }
        }
        return false;

    }
}
