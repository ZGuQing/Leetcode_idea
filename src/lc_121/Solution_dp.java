package lc_121;

/**
 * @author: Miguel
 * @date: 2020/12/28 5:00 下午
 * @description:
 */
public class Solution_dp {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;
        int[][] dp = new int[n + 1][2];
        for(int i = 0; i < n; i ++) {
            if(i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
            }
            res = Math.max(dp[i][0], res);
        }
        return res;
    }
}
