package lc_204;

import java.util.Arrays;

/**
 * @author: Miguel
 * @date: 2020/12/3 7:43 下午
 * @description:
 * 埃氏筛
 */
public class Solution1 {
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if(isPrime[i] == 1) {
                ans += 1;
                if((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {//从i*i开始标记,i*i,i*(i+1),....肯定都不是质数
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
