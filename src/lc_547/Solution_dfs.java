package lc_547;

/**
 * @author: Miguel
 * @date: 2020/12/18 7:00 下午
 * @description:
 * 把二维矩阵看成是无向图的邻接矩阵，该题实际上就是计算连通块的数量
 * 从图中我们发现，连通块就是可以从任意起点到达的所有节点。
 * 因此，连通块的个数，我们从每个未被访问的节点开始深搜，每开始一次搜索就增加count
 *
 */
public class Solution_dfs {
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if(M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if(visited[i] == 0) {
                dfs(M, visited, i);
                count ++;
            }
        }
        return count;
    }
}
