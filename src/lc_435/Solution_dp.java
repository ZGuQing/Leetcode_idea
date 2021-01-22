package lc_435;

import java.util.Arrays;

/**
 * @author: Miguel
 * @date: 2020/12/31 9:20 上午
 * @description:
 * 动态规划
 */
public class Solution_dp {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) {
            return 0;
        }
        //按右边界排序
        Arrays.sort(intervals, (int[] inter1, int[] inter2) -> Integer.compare(inter1[1], inter2[1]));

        int n = intervals.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(intervals[j][1] <= intervals[i][0]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        return n - Arrays.stream(f).max().getAsInt();
    }
}
