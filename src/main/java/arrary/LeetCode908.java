package arrary;

import org.junit.Test;

import java.util.Arrays;

import static java.util.Arrays.*;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode908.java
 * @Description 最小差值
 * @createTime 2022年04月30日 18:57:00
 */
public class LeetCode908 {

    public int smallestRangeI(int[] nums, int k) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1] - k;
        int min = nums[0]+k;
        int ans = max - min;
        return Math.max(ans, 0);
    }

    @Test
    public void main() {
        int[] arr = {1, 3, 6};
        int k=3;
        System.out.println(smallestRangeI(arr,k));
    }
}
