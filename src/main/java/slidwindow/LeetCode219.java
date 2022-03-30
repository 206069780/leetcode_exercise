package slidwindow;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode219.java
 * @Description 存在重复元素
 * @createTime 2022年03月26日 20:00:00
 */
public class LeetCode219 {
    /**
     * @param nums [1,2,3,1]
     * @param k    3
     * @return 是否存在目标
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {

        if (nums == null || nums.length < 2) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (Math.abs(i - j) <= k && nums[j] == nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> hasInt = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (hasInt.contains(nums[i])) {
                return true;
            }
            hasInt.add(nums[i]);
            if (hasInt.size() > k) {
                hasInt.remove(nums[i - k]);
            }
        }

        return false;
    }

    @Test
    public void test() {
        int[] arr = {1,2,3,1};
        boolean result = this.containsNearbyDuplicate(arr, 3);
        System.out.println(result);
    }
}
