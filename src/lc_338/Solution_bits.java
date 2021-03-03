package lc_338;

/**
 * @author: Miguel
 * @date: 2021/3/3 10:44 下午
 * @description:
 */

import org.junit.jupiter.api.Test;


public class Solution_bits {
    @Test
    public void test()
    {
        int num = 2;
        int[] ints = countBits(num);
        for(int i = 0; i < ints.length; i ++) {
            System.out.println(ints[i]);
        }
    }

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for(int i = 0; i <= num; i ++) {
            int t = 0;
            int x = i;
            while(x > 0) {
                if((x & 1) == 1) {
                    t ++;
                }
                x >>= 1;
            }
            res[i] = t;
        }
        return res;
    }
}
