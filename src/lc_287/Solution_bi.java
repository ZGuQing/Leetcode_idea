package lc_287;

import org.junit.jupiter.api.Test;

/**
 * @author: Miguel
 * @date: 2020/12/19 10:45 上午
 * @description:
 * 寻找重复数：二分法，区间二分
 */
public class Solution_bi {
    @Test
    public void test(){
        int[] nums = new int[]{1, 2, 3, 4, 4};
        int res = findDuplicate(nums);
        System.out.println(res);
    }
    public int findDuplicate(int[] nums) {
        int l = 0, r = nums.length;
        while(l < r) {
            int mid = l + r >> 1;
            int count = 0;
            for (int i = 0; i < nums.length; i++) { //遍历原数组，计算小于等于mid的数量
                if(nums[i] <= mid) {
                    count ++;
                }
            }
            if(count > mid) {//重复数在0，mid
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
