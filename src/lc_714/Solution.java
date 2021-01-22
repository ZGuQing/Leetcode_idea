package lc_714;

import org.junit.jupiter.api.Test;

/**
 * @author: Miguel
 * @date: 2020/12/17 11:22 下午
 * @description:
 * 714
 */
public class Solution {
    @Test
    public void test() {
        int[] prices = new int[] {1,3,7,5,10,3};
        int fee = 3;
        int maxPro = maxProfit(prices, fee);
        System.out.println(maxPro);
    }
    public int maxProfit(int[] prices, int fee) {
        int maxPro = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] - min  < 0) {
                min = prices[i];
            }
            else if(prices[i] - min - fee > 0) {
                maxPro += prices[i] - min - fee;
                min = prices[i] - fee;
            }
        }
        return maxPro;
    }
}
