package lc_648;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Miguel
 * @date: 2020/12/25 6:04 下午
 * @description:
 */
public class Solution {
    static int N = 1000010;
    static int son[][] = new int[N][26];
    static int idx;
    static int cnt[] = new int[N];
    public static String replaceWords(List<String> dictionary, String sentence) {
        for(String s : dictionary) {
            insert(s);
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (String s : sentence.split("\\s+")) {
            sb.append(query(dictionary, s));
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void insert(String s) {
        int len = s.length();
        int p = 0;
        for(int i = 0; i < len; i ++) {
            int u = s.charAt(i) - 'a';
            if(son[p][u] == 0) son[p][u] = ++ idx;
            p = son[p][u];
        }
    }

    public static String query(List<String> dictionary, String s) {
        StringBuilder sb = new StringBuilder();
        int p = 0;
        int len = s.length();
        for(int i = 0; i < len; i ++) {
            int u = s.charAt(i) - 'a';
            if(dictionary.contains(sb.toString())) {
                break;
            }
            if(son[p][u] == 0) return s;
            else {
                p = son[p][u];
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String sentence = "dasd sadsda dasda ada";
        List<String> dictionary = new ArrayList<>();
        dictionary.add("ad");
        dictionary.add("sa");
        String s = replaceWords(dictionary, sentence);
        System.out.println(s);
    }
}
