package lc_3;

/**
 * @author: Miguel
 * @date: 2020/11/24 11:44 上午
 * @description:
 * 字符串，双指针
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        //双指针算法
        int res = 0;
        int[] count = new int[10000];
        for (int i = 0, j = 0; i < s.length(); i++) {
            count[s.charAt(i)] ++;
            while(count[s.charAt(i)] > 1){//判断当前j～i有无重复字母
                count[s.charAt(j)] --;
                j ++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
