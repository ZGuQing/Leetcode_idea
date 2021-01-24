package lc_1584;

import java.util.*;

/**
 * @author: Miguel
 * @date: 2021/1/24 10:59 下午
 * @description:
 * 并查集和最小生成树
 */
public class Solution_kruskal {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DisjiontSetUnion dsu = new DisjiontSetUnion(n);
        List<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(dist(points, i, j), i, j));
            }
        }
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.len - o2.len;
            }
        });
        int ret = 0, num = 1;
        for(Edge edge : edges) {
            int len = edge.len, x = edge.x, y = edge.y;
            if(dsu.unionSet(x, y)) {
                ret += len;
                num ++;
                if(num == n) {
                    break;
                }
            }
        }
        return ret;
    }

    public int dist(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }
}
    class DisjiontSetUnion {
        int[] f;
        int[] rank;
        int n;

        public DisjiontSetUnion(int n) {
            this.n = n;
            this.rank = new int[n];
            Arrays.fill(this.rank,1);
            this.f = new int[n];
            for (int i = 0; i < n; i++) {
                this.f[i] = i;
            }
        }

        public int find(int x) {
            return f[x] == x ? x : (f[x] = find(f[x]));
        }

        public boolean unionSet(int x, int y) {
            int fx = find(x), fy = find(y);
            if(fx == fy) {
                return false;
            }
            if(rank[fx] < rank[fy]) {
                int temp = fx;
                fx = fy;
                fy = temp;
            }
            rank[fx] += rank[fy];
            f[fy] = fx;
            return true;
        }

    }

    class Edge {
        int len, x, y;

        public Edge(int len, int x, int y) {
            this.len = len;
            this.x = x;
            this.y = y;
        }
    }
