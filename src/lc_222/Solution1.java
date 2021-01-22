package lc_222;

/**
 * @author: Miguel
 * @date: 2020/11/24 10:47 上午
 * @description:
 * 树，深度优先搜索
 */
public class Solution1 {
    int count = 0;
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        count ++;
        countNodes(root.left);
        countNodes(root.right);
        return count;
    }
}




