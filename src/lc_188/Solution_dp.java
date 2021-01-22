package lc_188;

/**
 * @author: Miguel
 * @date: 2020/12/28 4:31 下午
 * @description:
 */
public class Solution_dp {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;
        int[][][]dp = new int[n + 1][k + 1][2];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j <= k; j ++) {
                if(i == 0 || j == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                }
                if(i > 0 && j > 0) {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j - 1][0] - prices[i], dp[i - 1][j][1]);
                }
            }
        }
        return dp[n - 1][k][0];
    }
}
