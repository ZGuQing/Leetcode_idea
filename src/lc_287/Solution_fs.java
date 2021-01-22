package lc_287;

/**
 * @author: Miguel
 * @date: 2020/12/19 10:59 上午
 * @description:
 * 快慢指针
 * 分析这个数组的特点，索引从0～n ，数组项的范围是1～n 。值域，在索引的范围内，值可以当索引使。
 * 题目转换成：求该有环链表的入环口。因为入环口的元素就是重复的链表节点值。
 */
public class Solution_fs {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) { //首次相遇
                fast = 0; //fast回到原点
                while(true) {
                    if(slow == fast) {
                        return slow;
                    }
                    slow = nums[slow];
                    fast = nums[fast];
                }
            }
        }
    }
}
