package lc_649;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author: Miguel
 * @date: 2020/12/11 3:10 下午
 * @description:
 * 649.Dota2 参议院
 */

class Solution {
    public String predictPartyVictory(String senate) {
        int numberR = 0, numberD = 0;//R,D阵营的总人数
        int curBanR = 0, curBanD = 0;//R,D阵营当前被ban人数
        int totalBanR = 0, totalBanD = 0;//R,D阵营总被ban人数
        char[] chars = senate.toCharArray();
//        boolean flag = true;
        while(true) {
            for (int i = 0; i < chars.length; i++) {;
                char c = chars[i];
                if(c == 'D') {
//                    if(flag) {
                        numberD ++;
//                    }
                    if(curBanD == 0) {
                        curBanR ++;
                        totalBanR ++;
                        // if(totalBanR == numberR && !flag) return "Radiant";
                    } else {
                        curBanD --;
                        chars[i] = 'd';
                    }
                } else if(c == 'R'){
//                    if(flag) {
                        numberR ++;
//                    }
                    if(curBanR == 0) {
                        curBanD ++;
                        totalBanD ++;
                        // if(totalBanD == numberD && !flag) return "Dire";
                    } else {
                        curBanR --;
                        chars[i] = 'r';
                    }
                }
            }
//            flag = false;
            if(totalBanD >= numberD) return "Radiant";
            if(totalBanR >= numberR) return "Dire";
        }
    }
}