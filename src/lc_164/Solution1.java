package lc_164;

import java.util.Arrays;

/**
 * @author: Miguel
 * @date: 2020/11/26 5:32 下午
 * @description:
 * 164.最大间距
 */
public class Solution1 {
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        Arrays.sort(nums);
        int maxGap = 0;
        for (int i = 0,j = i + 1; i < nums.length - 1; i++, j++) {
            int gap = Math.abs(nums[j] - nums[i]);
            if(maxGap <= gap) {
                maxGap = gap;
            }
        }
        return maxGap;
    }
}
