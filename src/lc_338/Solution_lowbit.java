package lc_338;

/**
 * @author: Miguel
 * @date: 2021/3/3 11:01 下午
 * @description:
 */
public class Solution_lowbit {
    public int[] countBits(int num) {
        int[] bit = new int[num + 1];
        for(int i = 0; i <= num; i ++) {
            bit[i] = bit[i >> 1] + (i & 1);
        }
        return bit;
    }
}
