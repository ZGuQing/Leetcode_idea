package lc_1208;

import org.junit.jupiter.api.Test;

/**
 * @author: Miguel
 * @date: 2021/2/5 9:55 上午
 * @description:
 */
public class Solution_sildwindow {
    @Test
    public void test() {
        String s = "krpgjbjjznpzdfy";
        String t = "nxargkbydxmsgby";
        int maxCost = 14;
        int res = equalSubstring(s, t, maxCost);
        System.out.println(res);

    }
    public int equalSubstring(String s, String t, int maxCost) {
        int count = 0, res = 0, cost = 0;
        int n = s.length();
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) { //创建数组存放差值，可以提高运行效率
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        for(int i = 0; i < n; i ++ ) {
            cost += diff[i];
            count ++;
            if(cost > maxCost) {
                cost -= diff[i - count + 1];
                count--;
            }
            res = Math.max(count, res);
        }
        return res;
    }
}
