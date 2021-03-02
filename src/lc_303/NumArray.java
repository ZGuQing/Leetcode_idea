package lc_303;

/**
 * @author: Miguel
 * @date: 2021/3/2 4:49 下午
 * @description:
 */
public class NumArray {
    int[] s;
    public NumArray(int[] nums) {
        int len = nums.length;
        if(len > 0) {
            s = new int[len + 1];
            s[0] = nums[0];
            for(int i = 0; i < len - 1; i ++)
                s[i + 1] = s[i] + nums[i + 1];
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0) return s[j];
        else return s[j] - s[i - 1];
    }
}
