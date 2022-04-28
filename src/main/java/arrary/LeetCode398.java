package arrary;

import org.junit.Test;

import java.util.*;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode398.java
 * @Description 随机数索引
 * @createTime 2022年04月25日 23:06:00
 */
public class LeetCode398 {
    Map<Integer, List<Integer>> tmpMap = new HashMap<>();
    Random random = new Random();

    public LeetCode398(int[] nums) {
        for (int i =0;i<nums.length;i++) {
            if (tmpMap.containsKey(nums[i])) {
                List<Integer> tmp = tmpMap.get(i);
                tmp.add(i);
                tmpMap.put(i, tmp);
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                tmpMap.put(i, tmp);
            }
        }

    }

    public int pick(int target) {
        List<Integer> indexes = tmpMap.get(target);
        return indexes.get(indexes.get(random.nextInt(indexes.size())));
    }

    @Test
    public void main() {

    }
}
