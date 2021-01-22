package lc_989;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Miguel
 * @date: 2021/1/22 8:34 下午
 * @description:
 * 将整个加数K加入数组表示的数的最低位。
 */
public class Solution1 {
    public List<Integer> addToArarayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int n = A.length;
        for(int i = n - 1; i >= 0 || K > 0; --i, K /= 10) {
            if(i >= 0) {
                K += A[i];
            }
            res.add(K % 10);
        }
        Collections.reverse(res);
        return res;
    }

}
