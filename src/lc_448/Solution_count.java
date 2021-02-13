package lc_448;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Miguel
 * @date: 2021/2/13 9:36 上午
 * @description:
 */
public class Solution_count {
    /**
     * 找到所有数组中消失的数字
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1];
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i ++ ) {
            count[nums[i]] ++;
        }
        for(int i = 1; i <= n; i ++ ) {
            if(count[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }
}
