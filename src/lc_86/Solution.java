package lc_86;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Miguel
 * @date: 2021/1/3 12:53 下午
 * @description:
 * 分割链表
 */
public class Solution {
    @Test
    public void test() {
        ListNode node1 = new ListNode(1,null);
        ListNode node2 = new ListNode(3, node1);
        ListNode node3 = new ListNode(1, node2);
        ListNode node4 = new ListNode(4, node3);
        ListNode node5 = new ListNode(0, node4);
        ListNode head = new ListNode(2, node5);
        ListNode p = head;
        while(p != null) {
            System.out.println("原链表：" + p.val);
            p = p.next;
        }
        System.out.println("*********************");
        int x = 4;
        ListNode res = partition(head, x);
        ListNode q = res;
        while(q != null) {
            System.out.println("现链表：" + q.val);
            q = q.next;
        }
    }
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prior = newHead;
        ListNode cur = head, tPrior = head, tran = head.next;
        while(cur != null && tran != null) {
            if(cur.val >= x) {
                while(tPrior != null && tran != null) {
                    if(tran.val < x) {
                        ListNode p = tran;
                        tPrior.next = p.next;
                        p.next = cur;
                        prior.next = p;
                        prior = p;
                    }else {
                        tPrior = tPrior.next;
                    }
                    if(tPrior != null) {
                        tran = tPrior.next;
                    }
                }
            } else {
                prior = cur;
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}
