package binarysearch;

import org.junit.Test;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName leetcode704.java
 * @Description 二分查找
 * @createTime 2022年03月27日 15:46:00
 */
public class leetcode704 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int mid = (left + right) / 2;
        while (left <= right) {
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
                mid = (left + right) / 2;
            } else {
                left = mid+1;
                mid = (left + right) / 2;
            }
        }
        return -1;
    }

    @Test
    public void main() {
        int[] arr = {-1,0,3,5,9,12};
        System.out.println(search(arr,13));
    }

}
