package lc_2;

/**
 * @author: Miguel
 * @date: 2020/11/23 12:02 上午
 * @description:
 * 2.两数相加
 * Tips：链表
 */


class ListNode { // 链表结构
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //我的版本
        ListNode l3 = new ListNode(0);
        ListNode p = l3;
        int t = 0;//进位
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;//挺好的想法
            int n2 = l2 != null ? l2.val : 0;
            int sum = (n1 + n2 + t);
            p.next = new ListNode(sum % 10);
            t = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            p = p.next;
        }
        if (t > 0) p.next = new ListNode(1, null);
        return l3.next;
        //答案版本
        // ListNode head = null, tail = null;
        // int t = 0;//进位
        // while (l1 != null || l2 != null) {
        //     int n1 = l1 != null ? l1.val : 0;
        //     int n2 = l2 != null ? l2.val : 0;
        //     int sum = (n1 + n2 + t);
        //     if(head == null){
        //         head = tail = new ListNode(sum % 10);
        //     }else{
        //         tail.next = new ListNode(sum % 10);
        //         tail = tail.next;
        //     }
        //     t = sum / 10;
        //     if(l1 != null){
        //         l1 = l1.next;
        //     }
        //     if(l2 != null){
        //         l2 = l2.next;
        //     }
        // }
        // if (t > 0) tail.next = new ListNode(t);
        // return head;
    }
}
