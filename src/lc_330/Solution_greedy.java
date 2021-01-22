package lc_330;

import org.junit.jupiter.api.Test;

/**
 * @author: Miguel
 * @date: 2020/12/29 2:07 下午
 * @description:
 * 按要求补齐数组
 */
public class Solution_greedy {
    @Test
    public void test() {
        int[] nums = new int[]{1, 3};
        int n = 6;
        int res = minPatches(nums, n);
        System.out.println(res);
    }
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long x = 1;
        int length = nums.length, index = 0;
        while(x <= n) {
            if(index < length && nums[index] <= x) { //x被覆盖，扩充被覆盖区间
                x += nums[index];
                index ++;
            } else { //x未被覆盖，补x，将x乘2
                x *= 2;
                patches ++;
            }
        }
        return patches;
    }
}
