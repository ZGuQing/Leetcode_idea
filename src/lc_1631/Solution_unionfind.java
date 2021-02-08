package lc_1631;

import java.util.*;

/**
 * @author: Miguel
 * @date: 2021/1/29 5:24 下午
 * @description:
 */
public class Solution_unionfind {
    public int minimumEffortPath(int[][] heights) {
        Scanner scanner = new Scanner(System.in);
        int m = heights.length;
        int n = heights[0].length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int id = i * n + j;
                if(i > 0) {
                    edges.add(new int[] {id - n, id, Math.abs(heights[i][j] - heights[i - 1][j])});
                }
                if(j > 0) {
                    edges.add(new int[] {id - 1, id, Math.abs(heights[i][j] - heights[i][j - 1])});
                }
            }
        }
        Collections.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] edge1, int[] edge2) {
                return edge1[2] - edge2[2];
            }
        });

        UnionFind uf = new UnionFind(m * n);
        int ans = 0;
        for(int[] edge : edges) {
            int x = edge[0], y = edge[1], v = edge[2]; //两个顶点和权值
            uf.unite(x, y);
            if(uf.connected(0, m * n - 1)) {
                ans = v;
                break;
            }
        }
        return ans;
    }
}

//并查集模板
class UnionFind {
    int[] parent;
    int[] size;
    int n;
    int setCount; //当前连通分量个数

    public UnionFind(int n) {
        this.n = n;
        this.setCount = n;
        this.size = new int[n];
        Arrays.fill(size, 1);
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    public boolean unite(int x, int y) {
        int px = find(x);
        int py = find(y);
        if(px == py) return false;
        if(size[px] < size[py]) {
            int temp = x;
            x = y;
            y = temp;
        }
        parent[py] = px;
        size[px] += size[py];
        --setCount;
        return true;
    }

    public boolean connected(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }
}
