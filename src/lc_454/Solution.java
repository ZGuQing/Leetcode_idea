package lc_454;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Miguel
 * @date: 2020/11/27 8:09 下午
 * @description:
 * 454.四数相加
 * 分组和哈希表
 *
 */
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> countAB = new HashMap<>();
        for(int u : A) {
            for(int v : B) {
                //键值对，键表示的是A[i]+B[j]，值为A[i]+B[j]出现的次数。
                countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
            }
        }
        int ans = 0;
        for(int u : C) {
            for(int v : D) {
                if(countAB.containsKey(-u - v)) {
                    ans += countAB.get(-u - v);
                }
            }
        }
        return ans;
    }
}
