package lc_389;

/**
 * @author: Miguel
 * @date: 2020/12/18 11:13 上午
 * @description:
 * 位运算：字符异或
 * a^a^b=b,将两个字符串所有的字符异或，最后的结果就是多出来的字符。
 */
public class Solution_bit {
    public char findTheDifference(String s, String t) {
        char c = t.charAt(t.length() - 1);
        int len = s.length();
        for (int i = 0; i < len; i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
}
