package lc_76;

import org.junit.jupiter.api.Test;

/**
 * @author: Miguel
 * @date: 2021/2/9 10:38 上午
 * @description:
 */
public class Solution_bip {
    /**
     * 求最小覆盖子串
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if(lenT > lenS) return "";
        int count = 0;
        int[] freq = new int[200]; //保存需要覆盖的字符频数
        int[] have = new int[200]; //保存当前窗口的字符频数

        int left = 0, right = 0;//左边界和右边界
        int len = Integer.MAX_VALUE;
        String res = "";
        for (int i = 0; i < lenT; i++) {
            char c = t.charAt(i);
            if(freq[c] == 0) {
                count ++; //t中不同字符个数
            }
            freq[c] ++;//t中所有字符频数
        }
        //找到左右边界
        while(right < lenS) {
            while(right < lenS && count > 0) { //右边界不断向右扩展子数组，count = 0时完全覆盖，此时右边界为right - 1
                if(++ have[s.charAt(right)] == freq[s.charAt(right)]) { //当有个字符个数达到它的频数，表示当前字符被完全覆盖，则count--
                    count --;
                }
                right ++;
            }
            while(count == 0) {//左边界不断向右收缩数组，当count != 0时，表示到左边界的后一个位置，此时左边界为left - 1
                if(--have[s.charAt(left)] < freq[s.charAt(left)]) {
                    count ++;
                }
                left ++;
            }
            if(right - left + 1 < len) {
                if(left - 1 < 0) { //左边界<0,此时为空
                    return "";
                }
                res = s.substring(left - 1, right);
                len = right - left + 1;
            }
        }

        return res;
    }

    @Test

    public void test() {
        String s = "aab";
        String t = "aa";

        String s1 = minWindow(s, t);
        System.out.println(s1);
    }
}
