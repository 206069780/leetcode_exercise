package arrary;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode1186.java
 * @Description 删除一次得到子数组最大和
 * @createTime 2022年04月29日 23:34:00
 */
public class LeetCode1186 { // TODO: 2022/4/29  
    public int maximumSum(int[] arr) {
        Arrays.sort(arr);
        int sum = arr[arr.length - 1];
        if (sum <= 0) {
            return sum;
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            sum = Math.max(sum + arr[i], sum);
        }
        return  sum;
    }

    @Test
    public void main(){
        int[] arr = {1, -2, 0, 3};
        System.out.println(maximumSum(arr));
    }
}
