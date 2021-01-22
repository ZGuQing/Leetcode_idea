package lc_455;

import java.util.Arrays;

/**
 * @author: Miguel
 * @date: 2020/12/25 10:18 上午
 * @description:
 * 分发饼干
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int m = g.length, n = s.length;
        int i = m - 1, j = n - 1;
        int ans = 0;
        while(i >= 0 && j >= 0) {
            if(g[i] <= s[j]) {
                j--;
                ans++;
            }
            i--;
        }
        return ans;
    }
}
