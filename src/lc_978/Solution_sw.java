package lc_978;

/**
 * @author: Miguel
 * @date: 2021/2/8 4:43 下午
 * @description:
 */
public class Solution_sw {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int res = 1;
        int left = 0, right = 0;
        while(right < n - 1) {
            if(left == right) {
                if(arr[left] == arr[left + 1]) {
                    left ++;
                }
                right ++;
            }else {
                if(arr[right - 1] < arr[right] && arr[right] > arr[right + 1] ) {
                    right ++;
                } else if(arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
                    right ++;
                } else {
                    left = right;
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
