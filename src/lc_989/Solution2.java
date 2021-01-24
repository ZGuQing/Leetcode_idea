package lc_989;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Miguel
 * @date: 2021/1/22 8:40 下午
 * @description:
 *
 */
public class Solution2 {
    public List<Integer> addToArarayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int n = A.length;
        for (int i = n - 1; i >= 0; i--) {
            int sum = A[i] + K % 10;
            K /= 10;
            if(sum >= 10) {
                K ++;
                sum -= 10;
            }
            res.add(sum);
        }
        for(; K > 0; K /= 10) {
            res.add(K % 10);
        }
        Collections.reverse(res);
        return res;
    }
}
