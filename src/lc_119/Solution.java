package lc_119;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Miguel
 * @date: 2020/12/16 7:56 下午
 * @description:
 * 119.杨辉三角II
 */
public class Solution {
    @Test
    public void test() {
        int num = 3;
        List<Integer> list = getRow(num);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.print(next + " ");
        }
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();//存放每行元素
        list.add(1);
        for (int i = 0; i < rowIndex; i++) {//遍历每一行
            for (int j = i; j >= 1; j--) {
                list.set(j, list.get(j - 1) + list.get(j)); //将下标为j的值设置为下标为j和下标为j-1的值的和
            }
            list.add(1);
        }
        return list;
    }
}
