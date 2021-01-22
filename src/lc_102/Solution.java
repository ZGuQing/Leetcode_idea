package lc_102;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Miguel
 * @date: 2020/12/17 10:45 上午
 * @description:
 * 102.二叉树的层序遍历
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null) return lists;
        Queue<TreeNode> queue = new LinkedList<>();
//        int level = 0;//记录当前层数
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int curLevel = queue.size();
            for(int i = 1; i <= curLevel; ++ i) { //加了个循环,计算每层有几个节点，全部出队
                TreeNode node = queue.poll();
                if(node != null) {
                    list.add(node.val);
                    if(node.left != null) {
                        queue.offer(node.left);
                    }
                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
