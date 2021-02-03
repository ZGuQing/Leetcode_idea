package lc_888;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Miguel
 * @date: 2021/2/3 10:18 下午
 * @description:
 */
public class Solution_hash {
    public int[] fairCandySwap(int[] A, int[] B) {
        //哈希表
        int sum1 = Arrays.stream(A).sum();
        int sum2 = Arrays.stream(B).sum();
        int d = (sum1 - sum2) / 2;
        Set<Integer> rec = new HashSet<Integer>();
        for(int num : A) {
            rec.add(num);
        }
        int[] ans = new int[2];
        for(int y : B) {
            int x = y + d;
            if(rec.contains(x)) {
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;
    }
}
