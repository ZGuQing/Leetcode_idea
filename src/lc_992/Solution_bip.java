package lc_992;

/**
 * @author: Miguel
 * @date: 2021/2/9 10:08 上午
 * @description:
 */
public class Solution_bip {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostWithKDistinct(A, K) - atMostWithKDistinct(A, K - 1);
    }

    /**
     * 最多包含K个不同整数的子区间的个数
     * @param A
     * @param K
     * @return
     */
    private int atMostWithKDistinct(int[] A, int K) {
        int len = A.length;
        int[] freq = new int[len + 1]; //频数数组

        int left = 0, right = 0;
        int count = 0;
        int res = 0;

        while(right < len) {
            if(freq[A[right]] == 0) {
                count ++;
            }
            freq[A[right]] ++;
            right ++;

            while(count > K) {
                freq[A[left]] --;
                if(freq[A[left]] == 0) {
                    count --;
                }
                left ++;
            }

            res += right - left;
        }
        return res;
    }
}
