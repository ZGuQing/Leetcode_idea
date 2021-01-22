package lc_135;

/**
 * @author: Miguel
 * @date: 2020/12/24 8:57 上午
 * @description:
 */
public class Solution_2 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if(ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec ++;
                if(dec == inc) {
                    dec ++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }
}
