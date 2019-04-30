import java.util.Arrays;

public class LeetCode016 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0;i<nums.length-2;i++){
            int low = i+1, high = nums.length -1;
            while(low<high){
                int sum = nums[i] + nums[low] + nums[high];
                int distance = target > sum?target - sum: sum - target;
                // System.out.println("i" + i + " distance:" + distance);
                if(distance <= min){
                    min = distance;
                    ans = sum;
                }
                if(target == sum){
                    return ans;
                }else if(target > sum){
                    low++;
                }else{
                    high--;
                }
            }
        }
        return ans;
    }
}
