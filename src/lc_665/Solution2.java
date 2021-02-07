package lc_665;

/**
 * @author: Miguel
 * @date: 2021/2/7 9:29 上午
 * @description:
 */
public class Solution2 {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 1; i < n; i ++) {
            if(i == n - 1) {
                if(nums[i - 1] > nums[i]) {
                    nums[i] = nums[i - 1];
                    count ++;
                }
            }else {
                if(nums[i - 1] > nums[i]) {
                    if(nums[i - 1] > nums[i + 1]) nums[i - 1] = nums[i];
                    else nums[i] = nums[i - 1];
                    count ++;
                }
            }
            if(count > 1) return false;
        }
        for(int i = 0; i < n - 1; i ++ ) {
            if(nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
