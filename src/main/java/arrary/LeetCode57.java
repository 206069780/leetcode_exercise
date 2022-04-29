package arrary;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode57.java
 * @Description 插入区间
 * @createTime 2022年04月29日 22:30:00
 */
public class LeetCode57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        boolean remember = true;
        for (int[] tmp : intervals) {
            if (tmp[0] > newInterval[1]) {
                if (remember) {
                    ans.add(newInterval);
                    remember = false;
                }
                ans.add(tmp);
            }
           else if (tmp[1] < newInterval[0]) {
                ans.add(tmp);
            }else {
                newInterval[0] = Math.min(newInterval[0], tmp[0]);
                newInterval[1] = Math.max(newInterval[1], tmp[1]);
            }
        }
        if (remember) {
            ans.add(newInterval);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    @Test
    public void main() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int[][] ans = insert(intervals, newInterval);
        for (int[] tmp : ans) {
            for (int i : tmp) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

}
