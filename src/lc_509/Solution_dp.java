package lc_509;

/**
 * @author: Miguel
 * @date: 2020/12/21 10:52 上午
 * @description:
 * 斐波那契数
 */
public class Solution_dp {
    public int fib(int n) {
        if(n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 1;
        for(int i = 2; i <= n; i ++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
