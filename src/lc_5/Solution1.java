package lc_5;

/**
 * @author: Miguel
 * @date: 2020/11/24 2:25 下午
 * @description:
 * 字符串，回文串，动态规划
 */
public class Solution1 {
    //对于一个子串而言，如果它是回文串并且长度大于2，那么它首尾的两个字母去除之后，仍然是一个回文串
    public String longestPalindrome(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }
}
