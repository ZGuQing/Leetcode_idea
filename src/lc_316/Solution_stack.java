package lc_316;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Stack;

/**
 * @author: Miguel
 * @date: 2020/12/20 12:29 上午
 * @description:
 *  去除重复字母
 */
public class Solution_stack {
    @Test
    public void test() {
        String s = "cdadabcc";
        String res = removeDuplicateLetters(s);
        System.out.println(res);
    }
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        int[] count = new int[26];
        boolean[] vis = new boolean[26]; //判断栈中若有该元素，则直接丢弃
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            count[c - 'a'] ++;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(!vis[c - 'a']) {
                while(!stack.isEmpty() && stack.peek() > c) {
                    if(count[stack.peek() - 'a'] > 0) {
                        vis[stack.peek() - 'a'] = false;
                        stack.pop();
                    } else {
                        break;
                    }
                }
                vis[c - 'a'] = true;
                stack.push(c);
            }
            count[c - 'a'] --;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        StringBuilder res = sb.reverse();
        return res.toString();
    }
}
