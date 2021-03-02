package lc_304;

/**
 * @author: Miguel
 * @date: 2021/3/2 1:21 下午
 * @description:
 */
public class NumMatrix {
    int[][] s; //前缀和数组

    public NumMatrix(int[][] matrix) {
        if(matrix.length > 0) {
            int row = matrix.length;
            int col = matrix[0].length;
            this.s = new int[row + 1][col + 1];
            for(int i = 1; i <= row; i++) {
                for(int j = 1; j <= col; j++) {
                    s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return s[row2 + 1][col2 + 1] - s[row1][col2 + 1] - s[row2 + 1][col1] + s[row1][col1];
    }
}
