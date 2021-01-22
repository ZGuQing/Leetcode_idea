package lc_136;

import org.junit.jupiter.api.Test;

/**
 * @author: Miguel
 * @date: 2020/12/18 3:07 下午
 * @description:
 * 只出现一次的数字：位运算
 * 与389找不同类似。
 */
public class Solution_bits {
    @Test
    public void test(){
        int[] nums = new int[]{2,1,2,1,4};
        int res = singleNumber(nums);
        System.out.println(res);
    }
    public int singleNumber(int[] nums) {
        int x = nums[0];
        for (int i = 1; i < nums.length; i++) {
            x ^= nums[i];
        }
        return x;
    }
}
