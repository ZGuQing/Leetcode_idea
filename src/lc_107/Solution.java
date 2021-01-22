package lc_107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Miguel
 * @date: 2020/12/22 11:50 下午
 * @description:
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if(root == null) return lists;
        Queue<TreeNode> queue = new LinkedList<>();
//        int level = 0;//记录当前层数
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int curLevel = queue.size();
            for(int i = 1; i <= curLevel; ++ i) { //加了个循环
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
            lists.add(0, list);
        }
        return lists;
    }
}
