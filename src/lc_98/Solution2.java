package lc_98;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Miguel
 * @date: 2020/11/25 4:22 下午
 * @description:
 *
 */
//2.中序遍历
public class Solution2 {
    //2.1 非递归中序遍历
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
//        if(root == null) return true;
//        Deque<TreeNode> stack = new LinkedList();//创建栈
//        while(root != null || !stack.isEmpty()){
//            while(root != null){
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            //判断前一个节点值是否大于当前节点值
//            if(prev != null && prev.val >= root.val){
//                return false;
//            }
//            prev = root;
//            root = root.right;
//        }
//        return true;

        //2.2递归的中序遍历
        if(root == null) return true;
        if(!isValidBST(root.left)) return false;
        if(prev != null && prev.val >=root.val){
            return false;
        }
        prev = root;
        return isValidBST(root.right);
    }
}
