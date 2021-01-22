package lc_976;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author: Miguel
 * @date: 2020/11/29 1:15 下午
 * @description:
 * 976.三角形的最大周长
 */
public class Solution {
    @Test
    public void test() {
        int[] A = new int[] {3,2,3,4};
        int per = largestPerimeter(A);
        System.out.println(per);
    }

    public int largestPerimeter(int[] A) {
        int perimeter = 0;
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if(isTriangle(A[i], A[i - 1], A[i - 2])) {
                perimeter = A[i] + A[i - 1] + A[i - 2];
                break;
            }
        }

        return perimeter;
    }

    public boolean isTriangle(int a, int b, int c) {
        if(a + b > c && a + c > b && b + c > a) {
            return true;
        }else {
            return false;
        }
    }
}
