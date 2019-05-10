public class LeetCode080 {
    public int removeDuplicates(int[] nums) {
        // int i = 0;
        // for (int n : nums)
        //     if (i < 2 || n > nums[i-2])
        //         nums[i++] = n;
        // return i;
        if (nums.length == 0) {return 0;}
        int pointer = 0, flag = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] && flag == 0) {
                flag = 1;
                pointer++;
            } else if (nums[i] != nums[i - 1]) {
                flag = 0;
                pointer++;
            }
            System.out.println(pointer + " " + i);
            nums[pointer] = nums[i];
        }
        return pointer + 1;
    }
}
