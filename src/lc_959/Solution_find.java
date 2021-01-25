package lc_959;

/**
 * @author: Miguel
 * @date: 2021/1/25 11:24 上午
 * @description:
 */
public class Solution_find {
    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        int size = 4 * N * N;

        UnionFind unionFind = new UnionFind(size);
        for (int i = 0; i < N; i++) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < N; j++) {
                //二维网格转换为一维表格
                int index = 4 * (i * N + j);
                char c = row[j];

                //单元格内合并
                if(c == '/') {
                    //合并0，3，合并1，2
                    unionFind.union(index, index + 3);
                    unionFind.union(index + 1, index + 2);
                } else if(c == '\\') {
                    //合并0，1，合并2，3
                    unionFind.union(index, index + 1);
                    unionFind.union(index + 2, index + 3);
                } else { //空格：合并0，1，2，3
                    unionFind.union(index, index + 1);
                    unionFind.union(index + 1, index + 2);
                    unionFind.union(index + 2, index + 3);
                }

                //单元格间合并
                //向右合并：1（当前），3（往右一列）
                if(j + 1 < N) {
                    unionFind.union(index + 1, 4 * (N * i + j + 1) + 3);
                }
                //向下合并：2（当前），0（向下一行）
                if(i + 1 < N) {
                    unionFind.union(index + 2, 4 *(N * (i + 1) + j));
                }
            }
        }
        return unionFind.getCount();
    }
}

class UnionFind {
    private int[] parent;

    private int count;

    public int getCount() {
        return count;
    }
    public UnionFind(int n) {
        this.count = n;
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int find(int x) {
        //递归写法
        // return parent[x] == x ? x : find(parent[x]);
        //while写法
        while(x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if(px == py) return;
        parent[px] = py;
        count --;
    }
}


