package lc_767;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: Miguel
 * @date: 2020/11/30 10:20 上午
 * @description:
 * 767:重构字符串
 * 堆，计数
 */
public class Solution {
    @Test
    public void test() {
        String s = "abababaaxcccxxx";
        String res = reorganizeString(s);
        System.out.println(res);
    }
    public String reorganizeString(String S) {
        if(S.length() < 2) {
            return S;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            counts[c - 'a'] ++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        if(maxCount > (length + 1) / 2) {
            return "";
        }
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character letter1, Character letter2) {
                return counts[letter2 - 'a'] - counts[letter1 - 'a'];
            }
        });
        for(char c = 'a'; c <= 'z'; c ++) {
            if(counts[c - 'a'] > 0) {
                queue.offer(c);
            }
        }
        StringBuilder str = new StringBuilder();
        while(queue.size() > 1) {
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            str.append(letter1);
            str.append(letter2);
            int index1 = letter1 - 'a', index2 = letter2 - 'a';
            counts[index1] --;
            counts[index2] --;
            if(counts[index1] > 0) {
                queue.offer(letter1);
            }
            if(counts[index2] > 0) {
                queue.offer(letter2);
            }
        }
        if(queue.size() > 0) {
            str.append(queue.poll());
        }
        return str.toString();
    }
}
