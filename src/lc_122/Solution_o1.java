package lc_122;

/**
 * @author: Miguel
 * @date: 2020/12/28 5:20 下午
 * @description:
 */
public class Solution_o1 {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int res = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            if (prices[i] > minPrice) {
                res += prices[i] - minPrice;
            }
            minPrice = prices[i];
        }
        return res;
    }
}
