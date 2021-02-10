package lc_567;

/**
 * @author: Miguel
 * @date: 2021/2/10 9:20 上午
 * @description:
 */
public class Solution_bip {
    /**
     * 字符串的排列：双指针，sliding window
     * 和完全覆盖那题类似
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 > len2) return false;
        int left = 0, right = 0;
        int[] freq = new int[128];
        int[] have = new int[128];
        int count = 0;

        for (int i = 0; i < len1; i++) {
            if(freq[s1.charAt(i)] == 0) count ++; //有几个不同字母
            freq[s1.charAt(i)] ++; //各字母个数
        }

        while(right < len2) {
            while(right < len2 && count > 0) {
                if(++ have[s2.charAt(right)] == freq[s2.charAt(right)]) {
                    count --;
                }
                right ++;
            }

            while(count == 0) {
                if(--have[s2.charAt(left)] < freq[s2.charAt(left)]) {
                    count ++;
                }
                left ++;
            }
            if(right - left + 1 == len1) {
                return true;
            }
        }
        return false;
    }
}
