package lc_100;

import org.junit.jupiter.api.Test;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Miguel
 * @date: 2020/12/17 9:51 上午
 * @description:
 * 100.相同的树
 */
public class Solution {
    @Test
    public void test() {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode p = new TreeNode(1, node1, null);
        TreeNode q = new TreeNode(1, null, node1);
        boolean sameTree = isSameTree(p, q);
        System.out.println(sameTree);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> list1 = new ArrayList<>();
        treeTra(p, list1);
        List<Integer> list2 = new ArrayList<>();
        treeTra(q, list2);
        return list1.equals(list2);
    }
    public void treeTra(TreeNode root, List<Integer> list) {
        if(root == null) {
            list.add(-1);
        } else {
            list.add(root.val);
            treeTra(root.left, list);
            treeTra(root.right, list);
        }
    }
}
