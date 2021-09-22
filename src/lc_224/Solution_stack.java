package lc_224;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author: Miguel
 * @date: 2021/3/11 12:24 上午
 * @description:
 */
public class Solution_stack {
    @Test
    public void test() {
        String s = " 2-1 + 2 ";
        int res = calculate(s);
        System.out.println(res);
    }
    public int calculate(String s) {
        Stack<Integer> st1 = new Stack<>(); //数字栈
        Stack<Character> st2 = new Stack<>(); //符号栈

        int i = 0, res = 0, n = s.length();

        while(i < n) {
            char c1 = s.charAt(i);
            if(c1 == ' ') i ++;
            if(c1 == '(') {
                st2.push(c1);
                break;
            } else if(c1 - '0' >= 0 && c1 - '0' <= 9){
                st1.push(c1 - '0');
                break;
            }
        }

        i ++;
        while((!st2.empty() || !st1.empty())) {
            if(i < n) {
                char c = s.charAt(i);
                if(c == '+' || c == '-' || c == '(') {
                    st2.push(c);
                } else if(c == ')') {
                    if(st2.peek() == '('){
                        st2.pop();
                    }
                } else if(c - '0' >= 0 && c - '0' <= 9){
                    if(!st1.empty()) {
                        if(!st2.empty() && st2.peek() == '+') {
                            int temp = c - '0';
                            res = temp + st1.pop();
                            st1.push(res);
                            st2.pop();
                        } else if(!st2.empty() && st2.peek() == '-') {
                            int temp = c - '0';
                            res = st1.pop() - temp;
                            st1.push(res);
                            st2.pop();
                        } else {
                            st1.push(c - '0');
                        }
                    } else {
                        st1.push(c - '0');
                    }
                }
                i ++;
            } else {
                while(!st2.isEmpty() && st1.size() >= 2) {
                    if (st2.peek() == '+') {
                        res = st1.pop() + st1.pop();
                        st1.push(res);
                        st2.pop();
                    } else if (st2.peek() == '-') {
                        int a = st1.pop();
                        int b = st2.pop();
                        res = b - a;
                        st1.push(res);
                        st2.pop();
                    }
                }
                while(!st2.isEmpty()) {
                    st2.pop();
                }
                while(!st1.isEmpty()) {
                    res = st1.pop();
                }
            }

        }
        return res;
    }
}
