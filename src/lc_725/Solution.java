package lc_725;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Miguel
 * @date: 2021/9/22 5:14 下午
 * @description:
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode p = head;

        //链表的长度
        int len = 0;
        while(p != null) {
            p = p.next;
            len ++;
        }

        int c = len / k;    //分为k段，每段有几个数
        int d = len % k;    //余下几个数，全部分到前面的段，当d>0时，该段的字数要+1
        ListNode[] parts = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k && curr != null; i++) {
            parts[i] = curr;
            int size = c + (i < d ? 1 : 0);
            for(int j = 1; j < size; j++ ) {
                curr = curr.next;
            }
            //断链
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return parts;

    }

}