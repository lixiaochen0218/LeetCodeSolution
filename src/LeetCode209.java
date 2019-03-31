public class LeetCode209 {
    // two pointers solution
    public int minSubArrayLen(int s, int[] nums) {
        int max = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int right = 0;
        int left = 0;
        for(;right<nums.length;right++){
            sum+=nums[right];
            while(sum>= s){
                ans = Math.min(ans, right + 1 - left);
                sum = sum - nums[left];
                left ++;
            }
        }
        if(ans != Integer.MAX_VALUE){
            return ans;
        }else{
            return 0;
        }
        // System.out.println("Max: " + max + "  Sum: " + sum);

    }

    //Tricky binery search solution

    public int minSubArrayLen2(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) sums[i] = sums[i - 1] + nums[i - 1];
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            int end = binarySearch(i + 1, sums.length - 1, sums[i] + s, sums);
            if (end == sums.length) break;
            if (end - i < minLen) minLen = end - i;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    private int binarySearch(int lo, int hi, int key, int[] sums) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (sums[mid] >= key){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
