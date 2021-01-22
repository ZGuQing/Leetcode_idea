package lc_204;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Miguel
 * @date: 2020/12/3 7:55 下午
 * @description:
 * 奇数筛
 */
public class Solution2 {
    public int countPrimes(int n) {
        List<Integer> primes = new ArrayList<>();//存放质数
        int[] isPrime = new int[n];//判断是否为质数
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; i++) {
            if(isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; j++) {
                isPrime[i * primes.get(j)] = 0;
                if(i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }
}
