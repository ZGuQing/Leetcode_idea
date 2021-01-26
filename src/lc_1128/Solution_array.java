package lc_1128;

import java.util.Arrays;

/**
 * @author: Miguel
 * @date: 2021/1/26 8:00 下午
 * @description:
 */
public class Solution_array {
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        int[] nums = new int[100];
        Arrays.fill(nums, 0);
        for(int[] domino : dominoes) {
            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[1];
            ans += nums[val] ++;
        }
        return ans;
    }
}
