package lc_1046;

import java.util.PriorityQueue;

/**
 * @author: Miguel
 * @date: 2020/12/30 10:07 上午
 * @description:
 */
public class Solution_heap {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }

        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if(a > b) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
