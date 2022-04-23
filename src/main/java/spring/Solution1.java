package spring;

import org.junit.Test;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName Solution1.java
 * @Description TODO
 * @createTime 2022年04月23日 15:00:00
 */
public class Solution1 {
    public int getMinimumTime(int[] time, int[][] fruits, int limit) {
        int sum = 0;
        for (int i = 0; i < fruits.length; i++) {
            int[] tmp = fruits[i];
            int timeTmp = tmp[0];
            sum+=tmp[1]%limit==0?time[timeTmp]*(tmp[1]/limit):time[timeTmp]*(tmp[1]/limit+1);
        }
        return sum;
    }

    @Test
    public void main() {
        int[] time = {1,3,2};
        int[][] fruits = {{0, 3}, {0,5}};
        System.out.println(getMinimumTime(time, fruits, 2));
    }
}
