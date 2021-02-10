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
        char[] chars = s.toCharArray();
        int []count = new int[200];
        //i右边界，j左边界
        for(int i = 0, j = 0; i < s.length(); i ++){
            count[chars[i]] ++;
            while(count[chars[i]] > 1){
                count[chars[j]] --;
                j ++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
