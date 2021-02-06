package lc_1423;

import java.util.Arrays;

/**
 * @author: Miguel
 * @date: 2021/2/6 9:33 上午
 * @description:
 */
public class Solution_sw {
    public int maxScore(int[] cardPoints, int k) { //滑动窗口，求最长连续的最小和，剩下的就是选中的最大和
        int sum = 0;
        int n = cardPoints.length;
        int m = n - k;
        int s = Arrays.stream(cardPoints).sum();
        for(int i = 0; i < m; i ++ ) sum += cardPoints[i];
        int res = sum;
        for(int i = m; i < n; i ++ ){
            sum = sum - cardPoints[i - m] + cardPoints[i];
            res = Math.min(res, sum);
        }
        return s - res;
    }

    public int maxScore1(int[] cardPoints, int k) { //直接利用滑动窗口求首末和最大值，效率更高
        int sum = 0;
        int n = cardPoints.length;
        for(int i = 0; i < k; i ++ ) sum += cardPoints[i];
        int res = sum;
        for(int i = k - 1; i >= 0; i -- ){
            sum += cardPoints[n + i - k]- cardPoints[i];//每次滑出左边最远的值，依次滑入右边的值
            res = Math.max(res, sum);
        }
        return res;
    }
}
