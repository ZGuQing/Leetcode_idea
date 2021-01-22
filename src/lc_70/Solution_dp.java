package lc_70;

/**
 * @author: Miguel
 * @date: 2020/12/21 10:45 上午
 * @description:
 * 爬楼梯
 * f(x) = f(x - 1) + f(x - 2),斐波那契数列
 */
public class Solution_dp {
    public int climbStairs(int n) {
        int p = 1, q = 1;
        for (int i = 2; i <= n; i++) {
            p = p + q;
            q = p - q;
        }
        return p;
    }
}
