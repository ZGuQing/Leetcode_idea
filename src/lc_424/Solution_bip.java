package lc_424;

import org.junit.jupiter.api.Test;

/**
 * @author: Miguel
 * @date: 2021/2/9 4:33 下午
 * @description:
 */
public class Solution_bip {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if(len < 2) return len;
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        int res = 0, maxCount = 0;
        int[] freq = new int[128];
        // [left, right) 内最多替换 k 个字符可以得到只有一种字符的子串
        while(right < len) {
            freq[chars[right]] ++;
            // 在这里维护 maxCount，因为每一次右边界读入一个字符，字符频数增加，才会使得 maxCount 增加
            maxCount = Math.max(maxCount, freq[chars[right]]);
            right ++;
            if(right - left > maxCount + k) {
                // 说明此时 k 不够用
                // 把其它不是最多出现的字符替换以后，都不能填满这个滑动的窗口，这个时候须要考虑左边界向右移动
                freq[chars[left]] --;
                left ++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    @Test
    public void test() {
        String s = "AABABBABB";
        int k = 2;
        int res = characterReplacement(s, k);
        System.out.println(res);
    }
}
