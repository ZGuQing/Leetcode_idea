package lc_1081;

/**
 * @author: Miguel
 * @date: 2020/12/20 3:16 下午
 * @description:
 */
public class Solution_sb {
    public String smallestSubsequence(String s) {
        boolean[] vis = new boolean[26];//用于标注栈中有无该字符
        int[] count = new int[26]; //用于计算剩余字符的数量
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            count[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(!vis[c - 'a']) {
                while(sb.length() > 0 && sb.charAt(sb.length() - 1) > c) { //用sb模拟栈
                    if(count[sb.charAt(sb.length() - 1)- 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1)- 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[c - 'a'] = true;
                sb.append(c);
            }
            count[c - 'a'] --;
        }
        return sb.toString();
    }
}
