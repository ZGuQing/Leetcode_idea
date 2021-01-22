package lc_452;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: Miguel
 * @date: 2020/11/23 11:50 上午
 * @description:
 */
public class Solution {
    @Test
    public void test(){
        int[][] points = new int[][]{{1,2},{3,4},{5,6},{7,8}};
        int minArrowShots = findMinArrowShots(points);
        System.out.println(minArrowShots);
    }
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }
        //按右边界排序
//        Arrays.sort(points, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] point1, int[] point2) {
//                if(point1[1] > point2[1]) {
//                    return 1;
//                }else if(point1[1] < point2[1]){
//                    return -1;
//                }else{
//                    return 0;
//                }
//            }
//        });
        Arrays.sort(points, (a, b) -> a[1] > b[1] ? 1 : -1);//lambda表达式
        int pos = points[0][1]; //当前箭射出的位置
        int ans = 1; //表示射出的箭数
        for(int i = 1; i < points.length; i ++) {
            //如果箭射入的位置小于下标为i的气球的左边位置，说明这支箭不能击爆下标为i的气球
            //需要再拿出一只箭，并且要更新这只箭射入的位置为下标为i+1的右边界
            if(points[i][0] > pos){
                pos = points[i][1];
                ++ans;
            }
        }
        return ans;
    }
}
