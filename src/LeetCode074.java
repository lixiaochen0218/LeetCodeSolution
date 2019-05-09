public class LeetCode074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length ==0) return false;
        int[] nums = helper(0,matrix.length-1,matrix,target);
        if(nums == null) return false;

        return helper2(0,nums.length-1,nums,target);
    }

    private int[] helper(int start, int end, int[][] matrix, int target){
        if(start==end) return matrix[start];
        if(start>end) return null;
        int mid = (start + end)/2;
        if(matrix[mid][0] <= target &&  target < matrix[mid +1][0])
            return matrix[mid];

        if(matrix[mid][0] > target){
            return helper(start, mid -1,matrix,target);
        }else{
            return helper(mid + 1,end,matrix,target);
        }
    }

    private boolean helper2(int start, int end, int[] nums, int target){
        if(start>end) return false;
        int mid = (start + end)/2;
        if(nums[mid] == target)
            return true;

        if(nums[mid] > target){
            return helper2(start, mid -1,nums,target);
        }else{
            return helper2(mid + 1,end,nums,target);
        }
    }
}
