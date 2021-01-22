package lc_135;

/**
 * @author: Miguel
 * @date: 2020/12/24 8:46 上午
 * @description:
 * 分发糖果
 */
public class Solution_1 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 1; i < n; i++) {
            if(ratings[i - 1] < ratings[i]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0, res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                right ++;
            } else {
                right = 1;
            }
            res += Math.max(left[i], right);
        }
        return res;
    }
}
