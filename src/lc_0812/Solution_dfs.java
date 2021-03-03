package lc_0812;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Miguel
 * @date: 2021/3/3 10:51 上午
 * @description:
 */
public class Solution_dfs {
    List<List<String>> res;
    char[][] g;
    boolean col[], dg[], udg[];
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        g = new char[n + 1][n + 1];
        col = new boolean[n + 10];
        dg = new boolean[n + 10];
        udg = new boolean[n + 10];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                g[i][j] = '.';
        dfs(0);
        return res;
    }

    public void dfs(int u) {
        List<String> list = new ArrayList();
        if (u == n) {
            for (int i = 0; i < n; i++) {
                String s = "";
                for (int j = 0; j < n; j++) {
                    s += g[i][j];
                }
                list.add(s);
            }
            res.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col[i] && !dg[u + i] && !udg[n - u + i]) {
                g[u][i] = 'Q';
                col[i] = dg[u + i] = udg[n - u + i] = true;
                dfs(u + 1);
                col[i] = dg[u + i] = udg[n - u + i] = false;
                g[u][i] = '.';
            }
        }
    }
}
