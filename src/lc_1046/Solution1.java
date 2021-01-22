package lc_1046;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Miguel
 * @date: 2020/12/30 9:30 上午
 * @description:
 */
public class Solution1 {
    @Test
    public void test() {
        int[] stones = new int[] {2,7,4,1,8,1};
        int res = Solution_heap.lastStoneWeight(stones);
        System.out.println(res);
    }
    public int lastStoneWeight(int[] stones) {
        List<Integer> list= new ArrayList<>();
        for (int i : stones) {
            list.add(i);
        }
        int size = list.size();
        while (size >= 1) {
            if(size == 1) {
                break;
            }
            Collections.sort(list);
            int max1 = list.get(size - 1);
            int max2 = list.get(size - 2);
            if (max1 == max2) {
                list.remove(size - 1);
                size --;
                list.remove(size - 2);
                size --;
            } else {
                list.remove(size - 1);
                size --;
                list.remove(size - 1);
                list.add(max1 - max2);
            }
        }
        if(size == 1) {
            return list.get(0);
        } else {
            return 0;
        }

    }
}
