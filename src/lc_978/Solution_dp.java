package lc_978;

import org.junit.jupiter.api.Test;

/**
 * @author: Miguel
 * @date: 2021/2/8 5:10 下午
 * @description:
 * dp[i][0]:表示以i为结尾且arr[i] > arr[i - 1]的最大连续湍流子数组
 * dp[i][1]:表示以i为结尾且arr[i] < arr[i - 1]的最大连续湍流子数组
 */
public class Solution_dp {
    @Test
    public void test() {
        int[] arr = new int[] {9,4,2,10,7,8,8,1,9};
        int res = maxTurbulenceSize(arr);
        System.out.println(res);
    }
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][2];
        if(n == 1) return 1;
        dp[0][0] = 1; dp[0][1] = 1;
        for(int i = 1; i < n; i ++) {
            if(arr[i] > arr[i - 1]) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = 1;
            }else if(arr[i] < arr[i - 1]) {
                dp[i][0] = 1;
                dp[i][1] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = 1;
                dp[i][1] = 1;
            }
        }
        int res = 1;
        for(int i = 0; i < n; i ++ ) {
            res = Math.max(dp[i][0], res);
            res = Math.max(dp[i][1], res);
        }
        return res;
    }

    //空间优化：o1
    public int maxTurbulenceSize_o1(int[] arr) {
        int n = arr.length;
        if(n == 1) return 1;
        int dp0 = 1, dp1 = 1;
        int res = 1;
        for(int i = 1; i < n; i ++) {
            if(arr[i] > arr[i - 1]) {
                dp0 = dp1 + 1;
                dp1 = 1;
            }else if(arr[i] < arr[i - 1]) {
                dp1 = dp0 + 1;
                dp0 = 1;
            } else {
                dp0 = 1;
                dp1 = 1;
            }
            res = Math.max(dp0, res);
            res = Math.max(dp1, res);
        }
        return res;
    }
}
