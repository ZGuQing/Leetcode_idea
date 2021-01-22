package lc_222;

/**
 * @author: Miguel
 * @date: 2020/11/24 11:18 上午
 * @description:
 * 完全二叉树的性质
 */
public class Solution2 {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int hl = levelTree(root.left);
        int hr = levelTree(root.right);
        if(hl == hr){
            return countNodes(root.right) + (1 << hl);
        }else{
            return countNodes(root.left) + (1 << hr);
        }
    }

    //计算树的高度
    public int levelTree(TreeNode root){
        int level = 0;
        while(root != null){
            level ++;
            root = root.left;
        }
        return level;
    }
}
