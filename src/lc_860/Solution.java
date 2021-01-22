package lc_860;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Miguel
 * @date: 2020/12/10 11:08 上午
 * @description:
 * 860.柠檬水找零
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        List<Integer> res = new ArrayList<>();
        int len = bills.length;
        for (int i = 0; i < len; i++) {
            if(bills[i] == 5){
                res.add(5);
            } else if(bills[i] == 10) {
                if(res.contains(5)) {
                    res.remove((Integer)5);
                    res.add(10);
                } else {
                    return false;
                }

            } else if(bills[i] == 20) {
                if(res.contains(10) && res.contains(5)) {
                    res.remove((Integer)10);
                    res.remove((Integer)5);
                    res.add(20);
                } else if(count5(res) >= 3){
                    res.remove((Integer)5);
                    res.remove((Integer)5);
                    res.remove((Integer)5);
                    res.add(20);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    public int count5(List<Integer> list) {
        int count = 0;
        for (int list1 : list) {
            if(list1 == 5){
                count++;
            }
        }
        return count;
    }
}
