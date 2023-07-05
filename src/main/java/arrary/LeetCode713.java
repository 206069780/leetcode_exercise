package arrary;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode713.java
 * @Description 乘积小于 K 的子数组
 * @createTime 2022年05月05日 22:51:00
 */
public class LeetCode713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l=0;
        int cnt=0;
        int sum=1;

        for (int i = 0; i < nums.length; i++) {
            sum *= nums[i];
            while (sum >= k) {
                sum /= nums[l];
                l++;
            }
            cnt += i - l + 1;
        }
        return 0;
    }
}
