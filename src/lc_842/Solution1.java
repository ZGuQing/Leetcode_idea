package lc_842;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Miguel
 * @date: 2020/12/8 10:13 上午
 * @description:
 */
public class Solution1 {
    @Test
    public void test() {
        String s = "123456579";
        List<Integer> list = splitIntoFibonacci(s);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    int len;
    public List<Integer> splitIntoFibonacci(String S) {
        len = S.length();
        List<Integer> res = new ArrayList<>();
        return dfs(0, S, res) ? res : new ArrayList<>();
    }

    private boolean dfs(int p, String S, List<Integer> res) {
        int size = res.size();
        if(p == len) {
            return size > 2;
        }
        int num = 0;
        for (int i = p; i < len; i++) {
            num = 10 * num + S.charAt(i) - '0';
            if(num < 0) {  //判断溢出
                return false;
            }
            if(size < 2 || num == res.get(size - 1) + res.get(size - 2)) {
                res.add(num);
                if (dfs(i + 1, S, res)) {
                    return true;
                }
                res.remove(size);  // ？？？？
            }
                if(S.charAt(i) - '0' == 0 && i == p) {  //判断是否以0开头，阻止循环到下一位
                    return false;
                }
        }
        return false;
    }
}
