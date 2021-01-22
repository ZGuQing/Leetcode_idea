package lc_321;

/**
 * @author: Miguel
 * @date: 2020/12/2 9:21 下午
 * @description:
 */
public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] maxSeq = new int[k];
        int start = Math.max(0, k - n), end = Math.min(k, m);
        for (int i = start; i <= end; i++) {
            int[] seq1 = maxSubsequence(nums1, i);
            int[] seq2 = maxSubsequence(nums2, k - i);
            int[] curMaxSeq = merge(seq1, seq2);
            if(compare(curMaxSeq, 0, maxSeq, 0) > 0) {
                System.arraycopy(curMaxSeq, 0, maxSeq, 0, k);
            }
        }
        return maxSeq;
    }

    public int[] maxSubsequence(int[] nums, int k) {//单调栈，用来挑选元素
        int len = nums.length;
        int[] stack = new int[k];
        int top = -1; //栈顶
        int remain = len - k;
        for(int i = 0; i < len; i ++) {
            int num = nums[i];
            while(top >= 0 && stack[top] < num && remain > 0) {
                top --;
                remain --;
            }

            if(top < k - 1) {
                stack[++top] = num;
            }else {
                remain --;
            }
        }
        return stack;
    }

    public int[] merge(int[] seq1, int[] seq2) {//合并两个子序列
        int x = seq1.length, y = seq2.length;
        if(x == 0) {
            return seq2;
        }
        if(y == 0) {
            return seq1;
        }
        int mergeLen = x + y;
        int[] merged = new int[mergeLen];
        int idx1 = 0, idx2 = 0;
        for (int i = 0; i < mergeLen; i++) {
            if(compare(seq1, idx1, seq2, idx2) > 0) {
                merged[i] = seq1[idx1 ++];
            } else {
                merged[i] = seq2[idx2 ++];
            }
        }
        return merged;
    }

    private int compare(int[] seq1, int idx1, int[] seq2, int idx2) {//比较两个序列大小
        int x = seq1.length, y = seq2.length;
        while(idx1 < x && idx2 < y) {
            int diff = seq1[idx1] - seq2[idx2];
            if(diff != 0) {
                return diff;
            }
            idx1 ++;
            idx2 ++;
        }
        return (x - idx1) - (y - idx2); //比谁的序列长？？？？
    }
}
