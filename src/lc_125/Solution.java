package lc_125;

import javax.xml.stream.events.Characters;

/**
 * @author: Miguel
 * @date: 2020/11/24 2:07 下午
 * @description:
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        int left = 0, right = s.length() - 1;
        while(left < right){
            //跳过不是字母和数字的字符
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left ++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right --;
            }
            if(left < right){
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                    return false;
                }
            }
            ++left;
            --right;
        }
        return true;
    }
}
