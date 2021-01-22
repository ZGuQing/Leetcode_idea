package lc_50;

import org.junit.jupiter.api.Test;

/**
 * @author: Miguel
 * @date: 2020/12/27 3:23 下午
 * @description:
 * pow(x,n) 快速幂+递归
 */
public class Solution {
    @Test
    public void test() {
        double res = myPow(2,10);
        System.out.println(res);
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, - N);
    }

    private double quickMul(double x, long n) {
        if(n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
