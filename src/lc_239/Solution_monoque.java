package lc_239;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Miguel
 * @date: 2021/1/2 2:48 下午
 * @description:
 */
public class Solution_monoque {
    static int N = 1000010;
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int q[] = new int[N];
        int hh = 0, tt = -1;
        for(int i = 0; i < n; i ++) {
            //判断队头是否在窗口内部，不在的话要删掉
            if(hh <= tt && i - k + 1 > q[hh]) {
                hh ++;
            }
            //队尾元素小于等于当前元素，则队尾元素出队，使得整个队列元素是单调递减的。
            while(hh <= tt && nums[q[tt]] <= nums[i]) {
                tt--;
            }
            q[++ tt] = i;
            if(i >= k - 1){
                list.add(nums[q[hh]]);
            }
        }
        int size = list.size();
        int[] res = new int[size];
        for(int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1,3,-1,4,3,7,1};
        int k = 3;
        int[] ints = maxSlidingWindow(nums, 1);
        System.out.println(ints);

    }
}
