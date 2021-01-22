package lc_34;

/**
 * @author: Miguel
 * @date: 2020/12/1 11:16 下午
 * @description:
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1, -1};
        int[] res = new int[2];
        int l = 0, r = nums.length - 1;
        while(l < r) {//左边界
            int mid = (l + r) >> 1;
            if(nums[mid] >= target) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        if(nums[l] != target){
            return new int[]{-1, -1};
        }
        else {//右边界
            res[0] = l;
            int i = 0, j = nums.length - 1;
            while(i < j) {
                int mid = (i + j + 1) >> 1;
                if(nums[mid] <= target) {
                    i = mid;
                } else {
                    j = mid - 1;
                }
            }
            res[1] = i;
        }
        return res;
    }
}
