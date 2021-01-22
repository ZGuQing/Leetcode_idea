package lc_861;

import org.junit.jupiter.api.Test;

/**
 * @author: Miguel
 * @date: 2020/12/7 10:55 上午
 * @description:
 * 861.翻转矩阵后的得分
 */
public class Solution {
    @Test
    public void test() {
        int[][] A = new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        int sum = matrixScore(A);
//        for (int i = 0; i < A.length; i++) {
//            for (int j = 0; j < A[0].length; j++) {
//                System.out.print(A[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(sum);
    }
    public int matrixScore(int[][] A) {
        int sum = 0;//记录结果
        int row = A.length;//数组的行数
        int col = A[0].length;
        for (int i = 0; i < row; i++) {
            if(A[i][0] == 0){//若每行的第一个元素是0，则翻转当前行所有元素
                for (int j = 0; j < col; j++) {
                    if(A[i][j] == 0) {
                        A[i][j] = 1;
                    } else {
                        A[i][j] = 0;
                    }

                }
            }
        }
        for (int i = 1; i < col; i++) {
            int count1 = 0;//记录每列1的个数
            int count2 = 0;//记录每列0的个数
            for (int j = 0; j < row; j++) {
                if(A[j][i] == 1) {
                    count1 ++;
                } else {
                    count2 ++;
                }
            }
            if(count2 > count1) {//若当前列中1的个数小于0的个数，则翻转当前列
                for (int j = 0; j < row; j++) {
                    if(A[j][i] == 0) {
                        A[j][i] = 1;
                    } else {
                        A[j][i] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
//                sum += A[i][j] * Math.pow(2,col - j - 1);
                sum += A[i][j] * (1 << (col - j - 1));
            }
        }
        return sum;
    }
}
