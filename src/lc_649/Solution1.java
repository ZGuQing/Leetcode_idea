package lc_649;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Miguel
 * @date: 2020/12/11 8:25 下午
 * @description:
 */
public class Solution1 {
    public String predictPartyVictory(String senate) {
        int len = senate.length();
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if(senate.charAt(i) == 'R') {
                r.offer(i);
            } else {
                d.offer(i);
            }
        }
        while (!r.isEmpty() && !d.isEmpty()) {
            int rIndex = r.poll(), dIndex = d.poll();
            if(rIndex < dIndex) {
                r.offer(rIndex + len);
            } else {
                d.offer(dIndex + len);
            }
        }
        return !r.isEmpty() ? "Radiant" : "Dire";
    }
}
