package lc_98;

/**
 * @author: Miguel
 * @date: 2020/11/25 4:07 下午
 * @description:
 * 98.验证二叉搜索树
 */
//递归，区间值判断
public class Solution1 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer low, Integer high){
        if(root == null) return true;

        int val = root.val;
        if(low != null && low >= val){
            return false;
        }
        if(high != null && high <= val){
            return false;
        }

        return isValidBST(root.left, low, val) && isValidBST(root.right, val, high);
    }
}
