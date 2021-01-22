package lc_989;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;

/**
 * @author: Miguel
 * @date: 2021/1/22 7:56 下午
 * @description:
 * 将k转为数组
 */
public class Solution {
    @Test
    public void test() {
        int[] A = new int[] {1,2,3,4};
        int k = 45;
        List<Integer> list = addToArarayForm(A, k);
    }
    public List<Integer> addToArarayForm(int[] A, int K) {
        List<Integer> ret = new ArrayList<>();
        String k = K + "";
        char[] chars = k.toCharArray();
        int[] ki = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ki[chars.length - i - 1] = chars[i] - '0';
        }
        for (int i = 0; i < A.length / 2; i++) {
            int temp = A[i];
            A[i] = A[A.length - i - 1];
            A[A.length - i - 1] = temp;
        }
        int t = 0;//进位
        int i = 0;
        while (i < A.length || i < ki.length) {
            if(i < ki.length && i < A.length) {
                int sum = A[i] + ki[i] + t;
                ret.add(sum % 10);
                t = sum / 10;
            }
            else if(i >= ki.length) {
                int sum = A[i] + t;
                ret.add(sum % 10);
                t = sum / 10;
            }
            else if(i >= A.length) {
                int sum = ki[i] + t;
                ret.add(sum % 10);
                t = sum / 10;
            }
            i ++;
        }
        if(t > 0) {
            ret.add(t);
        }
        Collections.reverse(ret);
        return ret;
    }
}
