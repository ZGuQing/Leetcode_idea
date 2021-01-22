package lc_118;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Miguel
 * @date: 2020/12/6 12:14 下午
 * @description:
 * 118.杨辉三角
 */
public class Solution {
    @Test
    public void test() {
        int num = 20;
        List<List<Integer>> list = generate(num);
        Iterator<List<Integer>> iterator = list.iterator();
        while(iterator.hasNext()) {
            List<Integer> next = iterator.next();
            for (int i : next) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
//        int[][]dp = generate1(num);
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                if(dp[i][j] != 0) {
//                    System.out.print(dp[i][j] + " ");
//                }
//
//            }
//            System.out.println();
//        }
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();//存放每行元素

        for (int i = 0; i < numRows; i++) {//遍历每一行
            List<Integer> row = new ArrayList<>();//存放一行中的n个元素
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(rows.get(i - 1).get(j - 1) + rows.get(i - 1).get(j));
                }
            }
            rows.add(row);
        }
        return rows;
    }

    public int[][] generate1(int numRows) { //动态规划
        int[][] dp = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
            for(int j = 1; j <= i; j ++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        return dp;
    }
}
