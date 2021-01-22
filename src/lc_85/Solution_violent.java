package lc_85;

/**
 * @author: Miguel
 * @date: 2020/12/26 5:26 下午
 * @description:
 */
public class Solution_violent {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }
        //保存以当前数字结尾的连续1的个数
        int[][] width = new int[matrix.length][matrix[0].length];
        int maxArea = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                //更新width
                if(matrix[row][col] == '1') {
                    width[row][col] = (col == 0 ? 1 : width[row][col - 1] + 1);
                } else {
                    width[row][col] = 0;
                }
                //
                int minWidth = width[row][col];
                //向上扩展行
                for (int up_row = row; up_row >= 0; up_row--) {
                    int height = row - up_row + 1;
                    //找最小的数作为矩阵的宽
                    minWidth = Math.min(minWidth, width[up_row][col]);
                    //更新面积
                    maxArea = Math.max(maxArea, height * minWidth);
                }
            }
        }
        return maxArea;
    }
}
