package lc_104;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Miguel
 * @date: 2020/12/22 2:20 下午
 * @description:
 * 二叉树的深度bfs:二叉树的层数就是二叉树的最大深度
 */
public class Solution_bfs {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                TreeNode cur = queue.poll();
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
                size --;
            }
            depth ++;
        }
        return depth;
    }
}
