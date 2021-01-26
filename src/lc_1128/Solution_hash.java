package lc_1128;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Miguel
 * @date: 2021/1/26 7:47 下午
 * @description:
 */
public class Solution_hash {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int[] domino: dominoes) {
            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[1];
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        for(int k : map.values()) {
            ans += (k * (k - 1) / 2);
        }
        return ans;
    }
}
