package lc_1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Miguel
 * @date: 2021/1/22 2:54 下午
 * @description:
 * 哈希表
 */
public class Solution_hash {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
