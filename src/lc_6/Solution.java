package lc_6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Miguel
 * @date: 2020/12/6 2:47 下午
 * @description:
 * 6.Z字形变换
 */
public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();

        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());//行数
        }

        int curRow = 0;//当前行数
        int flag = -1;//当前移动方向
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows - 1) {
                flag = -flag;
            }
            curRow += flag;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder sb : rows) {
            ret.append(sb);
        }
        return ret.toString();
    }
}
