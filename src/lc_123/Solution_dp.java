package lc_123;

/**
 * @author: Miguel
 * @date: 2020/12/28 4:32 下午
 * @description:
 */
public class Solution_dp {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;
        int[][][]dp = new int[n + 1][3][2];
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j <= 2; j ++) {
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
        return Math.max(dp[n - 1][1][0], dp[n - 1][2][0]);
    }
}
