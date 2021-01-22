package lc_86;

/**
 * @author: Miguel
 * @date: 2021/1/3 10:22 下午
 * @description:
 */
public class Solution_answer {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode smallP = small, largeP = large;
        while(head != null) {
            if(head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeP.next;
        return smallP.next;
    }
}
