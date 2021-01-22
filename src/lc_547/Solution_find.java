package lc_547;

import org.junit.jupiter.api.Test;

/**
 * @author: Miguel
 * @date: 2020/12/18 4:52 下午
 * @description:
 * 朋友圈
 */
public class Solution_find {
    int[] p = new int[201];
    public int findCircleNum(int[][] M) {
        int res = 0;
        int len = M[0].length;
        for(int i = 0; i < len; i ++) {
            p[i] = i;
        }
        for(int i = 0;i < len - 1; i ++) {
            for(int j = i + 1; j < len; j ++) {
                if(M[i][j] == 1) {
                    p[find(j)] = find(i);
                }
            }
        }
        int[] c = new int[201];
        for(int i = 0; i < len; i ++) {
            c[find(p[i])] ++;
            if(c[i] > 0) {
                res ++;
            }
        }
        return res;
    }
    public int find(int x) {
        if(p[x] != x) p[x] = find(p[x]);
        return p[x];
    }
    @Test
    public void test() {
//        int[][] M = new int[][] {{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
//                {0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},
//                {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
//                {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},
//                {0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}};
        int[][] M = new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        int res = findCircleNum(M);
        System.out.println(res);
    }
}
