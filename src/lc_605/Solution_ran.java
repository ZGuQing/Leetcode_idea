package lc_605;

import org.junit.jupiter.api.Test;

/**
 * @author: Miguel
 * @date: 2021/1/1 2:24 上午
 * @description:
 */
public class Solution_ran {
    @Test
    public void test() {
        int[] flowerbed = new int[]{0,0};
        int n = 1;
        boolean b = canPlaceFlowers(flowerbed, n);
        System.out.println(b);
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if(len == 1 && flowerbed[0] == 0) {
            n --;
        }
        for(int i = 1; i < len; i ++) {
            // if(flowerbed[i - 1] == 1) {
            //     continue;
            // }
            if(i == 1) {
                if (flowerbed[i - 1] == 0 && flowerbed[i] == 0) {
                    flowerbed[i - 1] = 1;
                    n--;
                }
            }else if(flowerbed[i - 2] == 0 && flowerbed[i - 1] == 0 && flowerbed[i] == 0) {
                flowerbed[i - 1] = 1;
                n --;
            }
            if(i == len - 1) {
                if(flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    n --;
                }
            }
        }
        return n <= 0 ? true : false;
    }
}
