package lc_387;

/**
 * @author: Miguel
 * @date: 2020/12/23 12:51 下午
 * @description:
 */
public class Solution_count {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            count[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < len; i++) {
            if(count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
