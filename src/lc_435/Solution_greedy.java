package lc_435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: Miguel
 * @date: 2020/12/31 8:58 上午
 * @description:
 */
public class Solution_greedy {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) {
            return 0;
        }
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] inter1, int[] inter2) {
//                return inter1[1] - inter2[1];
//            }
//        });
        Arrays.sort(intervals, (int[] inter1, int[] inter2) -> Integer.compare(inter1[1], inter2[1]));

        int right = intervals[0][1];
        int ans = 0;
        for(int i = 1; i < intervals.length; i ++) {
            if(right > intervals[i][0]) {
                ans ++;
            } else {
                right = intervals[i][1];
            }
        }
        return ans;
    }
}
