package lc_659;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Miguel
 * @date: 2020/12/4 10:35 上午
 * @description:
 * 贪心
 *
 */
public class Solution2 {
    public boolean isPossible(int[] nums) {
        //使用两个哈希表，第一个哈希表存储数组中的每个数字的剩余次数，
        // 第二个哈希表存储数组中的每个数字作为结尾的子序列的数量
        //初始时，每个数字的剩余次数即为每个数字在数组中出现的次数，因此遍历数组，初始化第一个哈希表。
        //第一步判断是否存在以x-1结尾的子序列，即根据第二个哈希表判断x-1作为结尾的子序列的数量是否大于0，
        //如果大于0，则将元素x加入到该子序列中。由于x被使用了一次，因此需要在第一个哈希表中将x的剩余次数减1，
        //又由于该子序列的最后一个数字从x-1变成了x，因此需要在第二个哈希表中将x-1作为结尾的子序列数量减一，以及
        //将x作为结尾的子序列的数量加一。否则，x为一个子序列的第一个数，为了得到长度至少为3的子序列。x+1和x+2
        //必须在子序列中，因此需要判断在第一个哈希表中x+1和x+2的剩余次数是否都大于0。

        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();
        for(int x : nums) {
            int count = countMap.getOrDefault(x, 0) + 1;
            countMap.put(x, count);
        }
        for(int x : nums) {
            int count = countMap.getOrDefault(x, 0);
            if(count > 0) {
                int preEndCount = endMap.getOrDefault(x - 1, 0);
                if(preEndCount > 0) {
                    countMap.put(x, count - 1);
                    endMap.put(x - 1, preEndCount - 1);
                    endMap.put(x, endMap.getOrDefault(x, 0) + 1);
                } else {
                    int count1 = countMap.getOrDefault(x + 1, 0);
                    int count2 = countMap.getOrDefault(x + 2, 0);
                    if(count1 > 0 && count2 > 0) {
                        countMap.put(x, count - 1);
                        countMap.put(x + 1, count1 - 1);
                        countMap.put(x + 2, count2 - 1);
                        endMap.put(x + 2, endMap.getOrDefault(x + 2, 0) + 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
