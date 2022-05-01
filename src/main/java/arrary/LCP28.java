package arrary;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LCP28.java
 * @Description
 * @createTime 2022年04月18日 20:08:00
 */
public class LCP28 {
    public int purchasePlans(int[] nums, int target) {

        int maxCount = 0;
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right --;
            } else {
                maxCount += right - left;
                left++;
            }
          maxCount=  maxCount % 1000000007;

        }
        return  maxCount;
    }

    @Test
    public void main() {
        int[] arr = {1, 2, 2, 9};
        System.out.println(purchasePlans(arr, 10));
    }
}
