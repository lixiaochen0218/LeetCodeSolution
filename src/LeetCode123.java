public class LeetCode123 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <2) return 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int max = 0;
        for(int i=0;i<prices.length-1;i++){
            left[i] = helper(prices,0,i);
            right[i] = helper(prices,i,prices.length-1);
            max = Math.max(max, left[i] + right[i]);
        }
        return max;
    }

    public int helper(int[] prices, int start, int end){
        if(prices == null || prices.length <2) return 0;
        int low = prices[start];
        int pointer = prices[start];
        int max = 0;
        for(int i=start;i<=end;i++){
            pointer = prices[i];
            if(pointer<low){
                low = pointer;
            }
            if(pointer > low){
                max = Math.max(pointer-low,max);
            }
        }
        return max;
    }
}
