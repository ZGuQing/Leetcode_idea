package lc_389;

/**
 * @author: Miguel
 * @date: 2020/12/18 12:25 上午
 * @description:
 * 找不同，计数
 */
public class Solution_count {
    public char findTheDifference(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            char c = s.charAt(i);
            count[c - 'a'] ++;
        }
        for (int i = 0; i < len2; i++) {
            char c = t.charAt(i);
            count[c - 'a'] --;
            if(count[c - 'a'] < 0) {
                return c;
            }
        }
        return ' ';
    }
}
