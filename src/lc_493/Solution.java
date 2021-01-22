package lc_493;

import org.junit.jupiter.api.Test;

/**
 * @author: Miguel
 * @date: 2020/11/28 11:20 下午
 * @description:
 */
public class Solution {
    @Test
    public void test() {
        int[] nums = new int[] {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        int count = reversePairs(nums);
        System.out.println(count);
    }

    public int reversePairs(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        return reversePairsMerge(nums, 0, nums.length - 1);

    }

    public int reversePairsMerge(int[] nums, int l, int r) {
        if(l == r) return 0;
        int mid = l + r >> 1;
        int n1 = reversePairsMerge(nums, l, mid);
        int n2 = reversePairsMerge(nums, mid + 1, r);
        int res = n1 + n2;

        //统计下标对的数量
        int i = l;
        int j = mid + 1;
        while(i <= mid) {
            while(j <= r && (long) nums[i] > 2 * (long) nums[j]) {
                j ++;
            }
            res += j - mid - 1;
            i ++;
        }

        //合并两个数组
        int[] sorted = new int[r - l + 1];
        int p1 = l, p2 = mid + 1;
        int p = 0;
        while(p1 <= mid || p2 <= r) {
            if(p1 <= mid && p2 <= r) {
                if(nums[p1] < nums[p2]) {
                    sorted[p ++] = nums[p1 ++];
                }else {
                    sorted[p ++] = nums[p2 ++];
                }
            }else if(p1 > mid) {
                sorted[p ++] = nums[p2 ++];
            }else {
                sorted[p ++] = nums[p1 ++];
            }
        }
        for(int k = 0; k < sorted.length; k ++) {
            nums[l + k] = sorted[k];
        }
        return res;
    }
}
