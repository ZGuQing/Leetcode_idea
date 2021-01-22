package lc_387;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Miguel
 * @date: 2020/12/23 1:02 下午
 * @description:
 */
public class Solution_map {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < length; i++) {
            if(map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
