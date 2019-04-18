public class LeetCode136 {
    public int singleNumber(int[] nums) {
        int ans =0;
        for(int i=0;i<nums.length;i++){
            ans = ans ^ nums[i];
            // System.out.println(ans);
        }
        return ans;
    }
}
/**
 If we take XOR of zero and some bit, it will return that bit
 a ^ 0 = a
 If we take XOR of two same bits, it will return 0
 a ^ a = 0
 a ^ b ^ a = b = (a ^ a) ^ b = b
 */