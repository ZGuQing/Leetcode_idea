package lc_5617;

import org.junit.jupiter.api.Test;

/**
 * @author: Miguel
 * @date: 2020/12/6 5:38 下午
 * @description:
 * 字符串解析器
 */
public class Solution {
    @Test
    public void test() {
        String command = "G()(al)";
        String s = interpret(command);
        System.out.println(s);
    }
    public String interpret(String command) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < command.length(); i++) {
            if(command.charAt(i) == 'G') {
                res.append('G');
            } else if(command.substring(i, i + 2).equals("()")){
                res.append('o');
                i ++;
            } else {
                res.append("al");
                i += 3;
            }
        }
        return res.toString();
    }
}
