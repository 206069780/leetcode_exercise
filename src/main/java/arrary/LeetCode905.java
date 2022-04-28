package arrary;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode.java
 * @Description 按奇偶排序数组
 * @createTime 2022年04月28日 22:49:00
 */
public class LeetCode905 {

    public int[] sortArrayByParity(int[] nums) {

        if (nums.length == 1) {
            return nums;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] % 2 == 0) {
                l++;
            } else {
                swap(nums, l, r--);
            }
        }
        return nums;
    }

    void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }


    @Test
    public void main() {
        int[] array = {1,2};

        int[] ans = sortArrayByParity(array);
        for (int i : ans) {
            System.out.print(i+" ");
        }
    }

}
