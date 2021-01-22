package lc_100;

/**
 * @author: Miguel
 * @date: 2020/12/17 10:30 上午
 * @description:
 */
public class Solution1 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }
}
