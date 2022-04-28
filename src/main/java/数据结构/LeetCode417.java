package 数据结构;

import org.junit.Test;

import java.util.List;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode417.java
 * @Description TODO
 * @createTime 2022年04月27日 23:33:00
 */
public class LeetCode417 {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] ao = new int[m][n];
        int[][] pa = new int[m][n];
// TODO: 2022/4/27
        for (int i = 0; i < n; i++) {
//            dfs(heights, pa, 0, i, 0);
//            dfs(heights, ao, m - 1, i);
        }
        return null;
    }

    public void dfs(int[][] heights, int[][] i, int k) {

    }

    @Test
    public void main() {

    }

}
