package lc_1319;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Miguel
 * @date: 2021/1/23 9:35 下午
 * @description:
 * dfs求图的连通分量
 */
public class Solution_dfs {
    List<Integer>[] edges;
    boolean[] used;

    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) {
            return -1;
        }

        edges = new List[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }
        for(int[] conn : connections) { //初始化图
            edges[conn[0]].add(conn[1]);
            edges[conn[1]].add(conn[0]);
        }

        used = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(!used[i]) {
                dfs(i);
                ++ ans;//图中的连通分量
            }
        }

        return ans - 1;
    }

    public void dfs(int u) {
        used[u] = true;
        for(int v : edges[u]) {
            if(!used[v]) {
                dfs(v);
            }
        }
    }
}
