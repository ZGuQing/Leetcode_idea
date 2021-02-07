package lc_665;

/**
 * @author: Miguel
 * @date: 2021/2/7 9:24 上午
 * @description:
 */
public class Solution1 {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n - 1; i ++) {
            int x = nums[i], y = nums[i + 1];
            if(x > y) {
                count ++;
                if(count > 1) return false;
                if(i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }

        }
        return true;
    }
}
