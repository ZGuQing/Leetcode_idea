package lc_438;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Miguel
 * @date: 2021/2/10 9:41 上午
 * @description:
 */
public class Solution_bip {
    /**
     * 找出字符串中所有的字母异位词
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        int lens = s.length();
        int lenp = p.length();

        int left = 0, right = 0;
        int count = 0;
        int[] freq = new int[128];
        int[] have = new int[128];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < lenp; i++) {
            if(freq[p.charAt(i)] == 0) count ++;
            freq[p.charAt(i)] ++;
        }

        while(right < lens) {
            while(right < lens && count > 0) {
                if(++have[s.charAt(right)] == freq[s.charAt(right)]) {
                    count --;
                }
                right ++;
            }

            while(count == 0) {
                if(--have[s.charAt(left)] < freq[s.charAt(left)]) {
                    count ++;
                }
                left ++;
            }

            if(right - left + 1 == lenp) {
                res.add(left - 1);
            }
        }
        return res;
    }
}
