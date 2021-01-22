package lc_621;

import java.util.*;

/**
 * @author: Miguel
 * @date: 2020/12/5 5:03 下午
 * @description:
 * 贪心
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        //创建Hash表
        Map<Character, Integer> freq = new HashMap<>();
        for(char ch : tasks) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        //任务总数
        int m = freq.size();
        //创建nextValid，rest数组
        List<Integer> nextValid = new ArrayList<>();
        List<Integer> rest = new ArrayList<>();
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            nextValid.add(1);
            rest.add(value);
        }

        int time = 0;
        for (int i = 0; i < tasks.length; i++) {
            ++time;
            int minNextValid = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                if(rest.get(j) != 0) {
                    minNextValid = Math.min(minNextValid, nextValid.get(j));
                }
            }
            time = Math.max(time, minNextValid);
            int best = -1;
            for (int j = 0; j < m; j++) {
                if(rest.get(j) != 0 && nextValid.get(j) <= time) {
                    if(best == -1 || rest.get(j) > rest.get(best)) {
                        best = j;
                    }
                }
            }
            nextValid.set(best, time + n + 1);
            rest.set(best, rest.get(best) - 1);
        }
        return time;
    }
}
