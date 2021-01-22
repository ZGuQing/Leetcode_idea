package lc_62;

/**
 * @author: Miguel
 * @date: 2020/12/9 9:00 上午
 * @description:
 * 组合数学
 */
public class Solution2 {
    public int uniquePaths(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
