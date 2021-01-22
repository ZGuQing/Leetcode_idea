package lc_738;

import org.junit.jupiter.api.Test;

/**
 * @author: Miguel
 * @date: 2020/12/15 7:54 下午
 * @description:
 * 738。单调递增的数字
 * 暴力求解
 * 贪心算法构造
 */
public class Solution {
    @Test
    public void test() {
        int n = 884564;
        int i = monotoneIncreasingDigits(n);
        int j = monotoneIncreasingDigits1(n);
        System.out.println(i);
        System.out.println(j);
    }
    public int monotoneIncreasingDigits(int N) {
        int i;
        for (i = N; i >= 0; i--) {
            boolean flag = true;
            String s = String.valueOf(i);
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length - 1; j++) {
                if(chars[j] > chars[j + 1]) {
                    flag = false;
                }
            }
            if(flag == true) {
                break;
            }
        }
        return i;
    }
    public int monotoneIncreasingDigits1(int N) {

        char[] chars = String.valueOf(N).toCharArray();

        int i = 1;
        //找到第一个单减的位置
        while(i < chars.length && chars[i] >= chars[i - 1]) {
            i++;
        }
        if(i < chars.length) {
            //然后将第一个单减位置的前一个元素减一，后面的位置补9
            while(i > 0 && chars[i] < chars[i - 1]) {
                chars[i - 1] -= 1;
                i --;
            }
            for (i += 1; i < chars.length; i ++) {
                chars[i] = '9';
            }
        }

        return Integer.parseInt(new String(chars));
    }
}
