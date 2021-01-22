package lc_205;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Miguel
 * @date: 2020/12/27 3:43 下午
 * @description:
 */
public class Solution_map {
    @Test
    public void test() {
        String s = "ab";
        String t = "aa";
        boolean isomorphic = isIsomorphic(s, t);
        System.out.println(isomorphic);
    }
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
        Map<Character, Character> map = new HashMap<>();
//        map.put(s.charAt(0), t.charAt(0));
        for (int i = 0; i < len; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if((!map.containsKey(c1) && map.containsValue(c2))) {
                return false;
            }
            if(!map.containsKey(c1)) {
                map.put(c1, c2);
            }
            if(map.get(c1) != c2) {
                return false;
            }

        }
        return true;
    }
}
