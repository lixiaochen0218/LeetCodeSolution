public class LeetCode410 {
    public int splitArray(int[] nums, int m) {
        int max = 0;
        long sum = 0;
        for (int num: nums) {
            max = Math.max(max, num);
            sum += num;
        }
        if (m == 1) return (int)sum;
        long l = (long)max; long r = sum;
        //binary search
        // l is the max number in nums[]
        // r is the sum of number in nums[]
        while(l <= r){
            long mid = (l + r)/2;
            if (valid(mid,nums,m)){
                r = mid -1;
            }else {
                l = mid + 1;
            }
        }
        return (int)l;
    }

    public boolean valid(long max, int[] nums, int m){
        int count = 1;
        long sum = 0;
        for(int num: nums){
            sum += num;
            if (sum > max){
                sum = num;
                count ++;
                if ( count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}
