package lc_1319;

import java.util.Arrays;

/**
 * @author: Miguel
 * @date: 2021/1/23 8:39 下午
 * @description:
 * 主要是得到图的连通分量
 */
public class Solution_union {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) {
            return -1;
        }

        UnionFind uf = new UnionFind(n);
        for(int[] conn : connections) {
            uf.unite(conn[0], conn[1]);
        }

        return uf.setCount - 1;
    }

    //并查集模版
    class UnionFind {
        int[] parent;
        int[] size;
        int n;
        //当前连通分量数目
        int setCount;

        public UnionFind(int n) {
            this.n = n;
            this.setCount = n;
            this.parent = new int[n];
            this.size = new int[n]; //一个连通分量的数量
            Arrays.fill(size, 1);
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int findset(int x) {
            return parent[x] == x ? x : (parent[x] = findset(parent[x]));
        }

        public boolean unite(int x, int y) {
            x = findset(x);
            y = findset(y);
            if(x == y) {
                return false;
            }
            if(size[x] < size[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            parent[y] = x;
            size[x] += size[y];
            --setCount;
            return true;
         }

         public boolean connected(int x, int y) {
            x = findset(x);
            y = findset(y);
            return x == y;
         }
    }
}
