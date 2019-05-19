public class LeetCode188 {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return helper(prices);

        int[][] dp = new int[k+1][len];
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i-1][0] - prices[0];
            System.out.println("level: " + i);
            for (int j = 1; j < len; j++) {
                dp[i][j] = Math.max(dp[i][j-1],  prices[j] + localMax);
                //System.out.print(" " + dp[i][j]);
                System.out.print(" " + localMax);
                localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
            }
        }
        return dp[k][len - 1];
    }

    private int helper(int[] prices) {
        int len = prices.length;
        int profit = 0;
        for (int i = 1; i < len; i++)
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
