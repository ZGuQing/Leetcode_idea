package lc_128;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Miguel
 * @date: 2020/12/16 9:19 下午
 * @description:
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longest = 0;
        for (int num : num_set) {
            if(!num_set.contains(num - 1)) {
                int curNum = num;
                int curLong = 1;

                while(num_set.contains(curNum + 1)) {
                    curNum += 1;
                    curLong += 1;
                }
                longest = Math.max(curLong, longest);
            }
        }
        return longest;
    }

}
