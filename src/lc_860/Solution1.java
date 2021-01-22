package lc_860;

/**
 * @author: Miguel
 * @date: 2020/12/10 12:24 下午
 * @description:
 * 模拟 + 贪心
 */
public class Solution1 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        int len = bills.length;
        for (int i = 0; i < len; i++) {
            if(bills[i] == 5) {
                five ++;
            } else if (bills[i] == 10) {
                if(five > 0) {
                    five --;
                    ten ++;
                } else{
                    return false;
                }
            } else {
                if(five > 0 && ten > 0) {
                    five --;
                    ten --;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
