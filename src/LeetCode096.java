public class LeetCode096 {
    public int numTrees(int n) {
        //f(n) = f(0) * f(n-1) + f(1) * f(n-2) + ... + f(n-2) * f(1) + f(n-1) * f(0)
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }
}
