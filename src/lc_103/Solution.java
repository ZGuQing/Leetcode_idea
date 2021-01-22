package lc_103;


import java.util.*;

/**
 * @author: Miguel
 * @date: 2020/12/17 2:34 下午
 * @description:
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null) return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;//记录当前层数
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
            if(level % 2 == 0) {
                Collections.reverse(list);
            }
            lists.add(list);
            level ++;
        }
        return lists;
    }
}
