package lc_209;

import java.util.Arrays;

/**
 * @author: Miguel
 * @date: 2021/2/9 3:40 下午
 * @description:
 */
public class Solution_prefix {
    /**
     * 前缀和+二分查找
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        int min = Integer.MAX_VALUE;
        int[] sums = new int[length + 1];
        for (int i = 1; i <= length; i++) {//求前缀和，递增
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 0; i <= length; i++) {
            int target = s + sums[i];
            //二分查找binarySearch:找到target就返回对应索引，找不到就返回下标的负值
            int index = Arrays.binarySearch(sums, target);
            if (index < 0)
                index = ~index;
            if (index <= length) {
                min = Math.min(min, index - i);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
