package lc_121;

/**
 * @author: Miguel
 * @date: 2020/12/28 4:33 下午
 * @description:
 */
public class Solution_violent {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;
        for(int i = 0; i < n - 1; i ++) {
            for(int j = i + 1; j < n; j ++) {
                res = Math.max(prices[j] - prices[i], res);
            }
        }
        return res;
    }
}
