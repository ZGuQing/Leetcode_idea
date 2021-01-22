package lc_628;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author: Miguel
 * @date: 2021/1/20 7:33 下午
 * @description:
 * 找最小的两个数和最大的三个数
 */
public class Solution {
    @Test
    public void test() {
        int []nums = new int[] {1,2,3};
        int ret = maximumProduct(nums);
        System.out.println(ret);
    }
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }
}
