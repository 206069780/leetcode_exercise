package arrary;

import org.junit.Test;

/**
 * @packageName: PACKAGE_NAME
 * @program: leetcode_exercise
 * @className: arrary.leetcode004
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-08-06  20:33
 * @description:
 **/
public class leetcode004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return getArrary(nums1, nums2);
    }

    //i： nums1长度
    public double getArrary(int[] nums1, int[] nums2) {

        // true 奇数   false 偶数
        boolean flag = (nums1.length + nums2.length) % 2 == 1;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] tmp = new int[nums1.length + nums2.length];
        int index1 = 0;
        int index2 = 0;
        int i = 0;

        if (flag) {
            while (index1 < len1 && index2 < len2) {
                if (nums1[index1] > nums2[index2]) {
                    tmp[i] = nums2[index2++];
                } else {
                    tmp[i] = nums1[index1++];
                }
//                toString(tmp);
                if (i == (nums1.length + nums2.length) / 2) return tmp[i];
                i++;
            }
        } else {
            while (index1 < len1 && index2 < len2) {

                if (nums1[index1] > nums2[index2]) {
                    tmp[i] = nums2[index2++];
                } else {
                    tmp[i] = nums1[index1++];
                }
                if (i == (nums1.length + nums2.length) / 2) {

                    return (double) (tmp[i] + tmp[i - 1]) / 2;
                }
                ;
                i++;
            }
        }
        while (index1 < len1) {
            tmp[i] = nums1[index1++];
            if (flag) {
                if (i == (nums1.length + nums2.length) / 2) return tmp[i];
                i++;
            } else {
                if (i == (nums1.length + nums2.length) / 2) return (double) (tmp[i] + tmp[i - 1]) / 2;
                i++;
            }
        }
        while (index2 < len2) {
            tmp[i] = nums2[index2++];
            if (flag) {
                if (i == (nums1.length + nums2.length) / 2) return tmp[i];
                i++;
            } else {
                if (i == (nums1.length + nums2.length) / 2) return (double) (tmp[i] + tmp[i - 1]) / 2;
                i++;
            }
        }
        throw new RuntimeException("Not Found");
    }

    @Test
    public  void main() {
        int[] num1 = {1, 2, 3, 4};
        int[] nums2 = {3, 4, 5, 6, 9};
        System.out.println(findMedianSortedArrays(nums2,num1));
    }

}
