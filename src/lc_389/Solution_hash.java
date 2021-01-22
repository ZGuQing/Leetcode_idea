package lc_389;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author: Miguel
 * @date: 2020/12/18 10:42 上午
 * @description:
 * 哈希表和计数一个原理
 */
public class Solution_hash {
    @Test
    public void test() {
        String s = "sda";
        String t = "sdab";
        char c = findTheDifference(s, t);
        System.out.println(c);
    }
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        int len1 = s.length();
        int len2 = t.length();
        for (int i = 0; i < len1; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

        }
        for (int i = 0; i < len2; i++) {
            char c = t.charAt(i);
            if(!map.containsKey(c)) {
                return c;
            }else {
                map.put(c, map.get(c) - 1);
                if(map.get(c) < 0) {
                    return c;
                }
            }
        }

        return ' ';
    }
}
