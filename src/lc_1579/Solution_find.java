package lc_1579;

import java.util.Arrays;

/**
 * @author: Miguel
 * @date: 2021/1/27 9:12 下午
 * @description:
 */
public class Solution_find {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int res = 0;
        UnionFind ufa = new UnionFind(n);
        UnionFind ufb = new UnionFind(n);

        //节点改为从0开始
        for(int[] edge : edges) {
            --edge[1];
            --edge[2];
        }

        //公共边
        for(int[] edge : edges) {
            if(edge[0] == 3) {
                if(!ufa.union(edge[1],edge[2])) {
                    ++ res;
                } else {
                    ufb.union(edge[1],edge[2]);
                }
            }
        }

        for(int[] edge : edges) {
            if(edge[0] == 1) { //alice
                if(!ufa.union(edge[1],edge[2])) {
                    ++ res;
                }
            } else if(edge[0] == 2) { //bob
                if(!ufb.union(edge[1],edge[2])) {
                    ++ res;
                }
            }
        }
        if(ufa.setCount != 1 || ufb.setCount != 1) {
            return -1;
        }
        return res;
    }
}

class UnionFind {
    int[] parent;
    int[] size;
    int n;
    int setCount;

    public UnionFind(int n) {
        this.n = n;
        this.setCount = n;
        this.parent = new int[n];
        this.size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }

    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if(px == py) {
            return false;
        }
        if(size[x] < size[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        parent[py] = px;
        size[px] += size[py];
        --setCount;
        return true;
    }
}