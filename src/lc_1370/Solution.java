package lc_1370;

import java.util.Arrays;

/**
 * @author: Miguel
 * @date: 2020/11/25 2:45 下午
 * @description:
 */
public class Solution {
    public String sortString(String s) {
        //桶排序
        int[] count = new int[26];//26个字母
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] ++;
        }

        StringBuilder sb = new StringBuilder();
        while(sb.length() < s.length()){
            //先正序遍历一遍count数组
            for (int i = 0; i < 26; i++) {
                if(count[i] > 0){
                    sb.append((char) (i + 'a'));
                    count[i] --;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if(count[i] > 0){
                    sb.append((char) (i + 'a'));
                    count[i] --;
                }
            }
        }
        return sb.toString();
    }
}
