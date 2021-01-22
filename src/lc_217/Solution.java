package lc_217;

/**
 * @author: Miguel
 * @date: 2020/12/13 9:33 下午
 * @description:
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < min) {
                min = nums[i];
            }
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        int k = max - min + 1;
        int[] count = new int[k];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] - min] ++;
        }
        for (int i = 0; i < count.length; i++) {
            if(count[i] > 1) {
                return true;
            }
        }
        return false;
    }
}
