package lc_338;

/**
 * @author: Miguel
 * @date: 2021/3/3 10:58 下午
 * @description:
 */
public class Solution_highbit {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        int highBit = 0;
        for(int i = 1; i <= num; i ++) {
            if((i & (i - 1)) == 0) {
                highBit = i;
            }
            res[i] = res[i - highBit] + 1;
        }
        return res;
    }
}
