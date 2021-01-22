package lc_84;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: Miguel
 * @date: 2020/12/26 4:08 下午
 * @description:
 * 单调栈
 */
public class Solution_violent {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < heights.length; j++) {
//                res = Math.max(res, getMin(heights, i, j) * (j - i + 1));
//            }
            while(!stack.empty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (right[i] - left[i] - 1) * heights[i]);
        }
        return res;
    }
//    public int getMin(int[] heights, int i, int j) {
//        int min = heights[i];
//        for (int k = i + 1; k <= j; k++) {
//            if(heights[k] < min) {
//                min = heights[k];
//            }
//        }
//        return min;
//    }
}
