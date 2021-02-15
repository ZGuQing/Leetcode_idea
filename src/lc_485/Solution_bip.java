package lc_485;

/**
 * @author: Miguel
 * @date: 2021/2/15 11:35 下午
 * @description:
 */
public class Solution_bip {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int n = nums.length;
        int left = 0, right = 0;
        while(right < n) {
            while(right < n && nums[right] == 1) {
                right ++;
            }
            res = Math.max(res, right - left);
            right ++;
            left = right;
        }
        return res;
    }
}
