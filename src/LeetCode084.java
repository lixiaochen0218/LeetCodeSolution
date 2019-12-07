public class LeetCode084 {
    public int largestRectangleArea(int[] heights) {
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
