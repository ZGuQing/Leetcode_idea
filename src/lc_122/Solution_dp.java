package lc_122;

/**
 * @author: Miguel
 * @date: 2020/12/28 5:07 下午
 * @description:
 */
public class Solution_dp {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for(int i = 0; i < n; i ++) {
            if(i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            }
        }
        return dp[n - 1][0];
    }
}
