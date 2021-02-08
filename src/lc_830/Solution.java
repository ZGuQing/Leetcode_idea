package lc_830;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.SubmissionPublisher;

/**
 * @author: Miguel
 * @date: 2021/1/5 10:34 下午
 * @description:
 */
public class Solution {
    @Test
    public void test() {
        String s = "aaa";
        List<List<Integer>> res = largeGroupPositions(s);
    }
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n - 1; i++) {
            List<Integer> list = new ArrayList<>();
            int pos = i;
            int j = i + 1;
            for (; j < n; j++) {
                if(chars[j] == chars[i]) {
                    pos ++;
                    continue;
                } else {
                    if(pos - i + 1 > 2) {
                        list.add(i);
                        list.add(pos);
                        res.add(list);
                        i = pos;
                        break;
                    }
                    break;
                }

            }
            if(j == n && pos - i + 1 > 2) {
                list.add(i);
                list.add(pos);
                res.add(list);
                i += pos;
            }
        }
        return res;
    }
}
