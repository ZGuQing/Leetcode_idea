package lc_209;

/**
 * @author: Miguel
 * @date: 2021/2/9 2:54 下午
 * @description:
 */
public class Solution_bip {
    /**
     * 求长度最小子数组
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        int sum = 0, sumN = 0;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; i ++ ) {
            sumN += nums[i];
        }
        if(sumN < target) return 0; //数组和小于给定值，直接返回0
        while(right < n) {
            while(right < n && sum < target) { //右边界向右扩展
                sum += nums[right];
                right ++;
            }
            while(left < n && sum >= target) {//左边界向右收缩
                sum -= nums[left];
                left ++;
            }
            res = Math.min(res, right - left + 1);
        }
        return res;
    }
}
