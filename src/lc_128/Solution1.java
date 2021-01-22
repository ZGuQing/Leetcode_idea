package lc_128;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Miguel
 * @date: 2020/12/16 10:02 下午
 * @description:
 */
public class Solution1 {
    public int find(int x, Map<Integer, Integer> map) {
        return map.containsKey(x) ? find(x + 1, map) : x;
    }
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int ans = 0;
        for (int i : nums) {
            if(!map.containsKey(i - 1)) {
                ans = Math.max(ans, find(i + 1, map) - i);
            }
        }
        return ans;
    }
}
