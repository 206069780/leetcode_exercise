package arrary;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode15.java
 * @Description
 * @createTime 2022年04月24日 21:36:00
 */
public class LeetCode15 {
    @Test
    public void main() {
        int[] arr = {0, 0, 0, 0};
        System.out.println(threeSum(arr).toString());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int currVal = nums[i], left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sumTmp = currVal + nums[left] + nums[right];
                if (sumTmp == 0) {
                    List<Integer> tmp = new ArrayList();
                    tmp.add(currVal);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
//                    while (left<right&& nums[left]==nums[left+1]){
//                        left--;}
//                    while (left<right&& nums[right]==nums[right-1]){
//                        --right;}
//                    res.add(tmp);
                    if (!res.contains(tmp)) {
                        res.add(tmp);
                    }
                    ++left;
                    --right;
                }
                if (sumTmp < 0) {
                    left++;
                }
                if (sumTmp > 0) {
                    --right;
                }
            }
        }
        return res;
    }
}
