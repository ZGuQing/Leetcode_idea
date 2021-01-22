package lc_101;

/**
 * @author: Miguel
 * @date: 2020/12/17 10:42 上午
 * @description:
 * 101.对称二叉树
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSym(root, root);
    }
    public boolean isSym(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        return isSym(root1.left, root2.right) && isSym(root1.right, root2.left);
    }
}
