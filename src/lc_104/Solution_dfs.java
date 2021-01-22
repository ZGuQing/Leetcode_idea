package lc_104;

/**
 * @author: Miguel
 * @date: 2020/12/22 2:16 下午
 * @description:
 * 104。二叉树的深度dfs
 */
public class Solution_dfs {
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode root, int depth) {
        if(root == null) return depth;
        return Math.max(maxDepth(root.left, depth + 1), maxDepth(root.right, depth + 1));
    }
}
