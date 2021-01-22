package lc_659;

import java.beans.IntrospectionException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author: Miguel
 * @date: 2020/12/4 9:26 上午
 * @description:
 * 最小堆+哈希表
 */
public class Solution1 {
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int x : nums) {
            if(!map.containsKey(x)) {
                map.put(x,new PriorityQueue<>());
            }
            if(map.containsKey(x - 1)) {
                int prevLength = map.get(x - 1).poll();
                if(map.get(x - 1).isEmpty()) {
                    map.remove(x - 1);
                }
                map.get(x).offer(prevLength + 1);
            } else {
                //map.get(x)：返回x关联的优先队列
                map.get(x).offer(1);
            }
        }
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
        for(Map.Entry<Integer, PriorityQueue<Integer>> entry : entrySet) {
            PriorityQueue<Integer> queue = entry.getValue();//得到队列
            if(queue.peek() < 3) {
                return false;
            }
        }
        return true;
    }
}
