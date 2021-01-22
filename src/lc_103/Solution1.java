package lc_103;

import java.util.*;

/**
 * @author: Miguel
 * @date: 2020/12/17 3:10 下午
 * @description:
 */
public class Solution1 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isOrder = true;
        queue.offer(root);
        while (!queue.isEmpty()) {
            Deque<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (isOrder) {
                    list.addFirst(curNode.val);
                } else {
                    list.addLast(curNode.val);
                }

                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            lists.add(new LinkedList<>(list));
            isOrder = !isOrder;
        }
        return lists;
    }
}