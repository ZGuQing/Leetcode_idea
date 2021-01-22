package lc_142;

/**
 * @author: Miguel
 * @date: 2020/12/19 11:21 上午
 * @description:
 * 环形链表II:快慢指针
 */
public class Solution_fsl {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null) { //无环的话两指针不可能相遇
            if(fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                fast = head;
                while(true) {
                    if(slow == fast) {
                        return slow;
                    }
                    slow = slow.next;
                    fast = fast.next;
                }
            }
        }
        return null;
    }
}
