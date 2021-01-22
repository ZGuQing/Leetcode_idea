package lc_1;

/**
 * @author: Miguel
 * @date: 2020/11/22 11:56 下午
 * @description:
 * 1.两数之和
 * Tips：数组，哈希表
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
