package lc_724;

import java.util.Arrays;

/**
 * @author: Miguel
 * @date: 2021/1/29 5:01 下午
 * @description:
 */
public class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for(int i = 0; i < n; i ++) { //尝试每个位置
            if(2 * sum + nums[i] == total) return i;
            sum += nums[i];
        }
        return -1;
    }
}
