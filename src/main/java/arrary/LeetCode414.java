package arrary;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode414.java
 * @Description 第三大的数®
 * @createTime 2022年04月18日 21:24:00
 */
public class LeetCode414 {

    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<>();
        for (int i : nums) {
            if (tmp.contains(i)) {
                continue;
            }
            tmp.add(i);
        }
        return tmp.size() >=3 ? tmp.get(tmp.size()-3) : tmp.get(tmp.size()-1);
    }

    @Test
    public void main() {
        int[] array = {3,0,0};
        System.out.println(thirdMax(array));
    }
}
