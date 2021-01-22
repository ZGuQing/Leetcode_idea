package lc_290;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author: Miguel
 * @date: 2020/12/16 10:20 上午
 * @description:
 * 290.单词规律
 */
public class Solution {
    @Test
    public void test() {
        String patten = "abba";
        String s = "dog cat cat ads";
        boolean b = wordPattern(patten, s);
        System.out.println(b);
    }
    public boolean wordPattern(String pattern, String s) {
        int len1 = pattern.length();
        String[] s1 = s.split(" ");
        if(len1 != s1.length) return false;
        HashMap<Character,String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < len1; i++) {
            char c = pattern.charAt(i);
            if(map.containsKey(c)) { //如果已经存在这个这个key，则判断key对应的value是否等于对应String数组中的字符串。
                if(!map.get(c).equals(s1[i])) {
                    return false;
                }
            } else {
                if(set.contains(s1[i])) { //该式成立，说明map中有两个key对应同一个value，直接返回false
                    return false;
                }
                map.put(c, s1[i]);
                set.add(s1[i]);
            }
        }
        return true;
    }
}
