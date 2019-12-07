public class LeetCode085 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int max = 0;
        int m = matrix.length, n= matrix[0].length;
        int[] heights = new int[n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++) {
                heights[j] = matrix[i][j] == '1'?heights[j] + 1:0;
            }
            max = Math.max(largestRectangleArea(heights), max);
        }
        return max;
    }

    private int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        int res = 0;
        for (int i=0;i<heights.length;i++){
            int l = i;
            int r = i;
            while(l >=0 && heights[l] >= heights[i]) l--;
            while(r < heights.length && heights[r] >= heights[i]) r++;

            res = Math.max(res, heights[i] * (r-l-1));
        }
        return res;
    }
}
