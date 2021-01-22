package lc_49;

import java.util.*;

/**
 * @author: Miguel
 * @date: 2020/12/14 5:33 下午
 * @description:
 * 1.排序
 * 哈希表：键表示的是排序后的字符串，值表示的是排序后的相同字符串列表
 */
public class Solution1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
