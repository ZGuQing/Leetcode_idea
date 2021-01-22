package lc_205;

/**
 * @author: Miguel
 * @date: 2020/12/27 5:19 下午
 * @description:
 * 快速幂+迭代
 */
public class Solution1 {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, - N);
    }

    private double quickMul(double x, long n) {
        double ans = 1.0;
        double x_con = x;
        while(n > 0) {
            if(n % 2 == 1) {
                ans *= x_con;
            }
            x_con  *= x_con;
            n /= 2;
        }
        return ans;
    }
}
