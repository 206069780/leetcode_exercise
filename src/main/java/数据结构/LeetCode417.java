package 数据结构;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode417.java
 * @Description 太平洋大西洋水流问题
 * @createTime 2022年04月27日 23:33:00
 */
public class LeetCode417 {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] ao = new int[m][n];
        int[][] pa = new int[m][n];
        //上下查找
        for (int i = 0; i < n; i++) {
            dfs(heights, pa, 0, i); // 上边查找
            dfs(heights, ao, m - 1, i); // 下边查找
        }
        // 左右遍历
        for (int i = 0; i < m; i++) {
            dfs(heights, pa, i, 0); // 左边遍历
            dfs(heights, ao, i, n - 1); // 右边遍历
        }
        // 返回结果
        List<List<Integer>> ansList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ao[i][j] == pa[i][j]) {
                    ansList.add(Arrays.asList(i, j));
                }
            }
        }
        return ansList;
    }

    public void dfs(int[][] heights, int[][] temp, int i, int j) {
        temp[i][j] = 1;
        // 左右移动
        int[] lOrR = {-1, 1, 0, 0};
        // 上下移动
        int[] uOrD = {0, 0, 1, -1};

        for (int k = 0; k < lOrR.length; k++) {
            int x = i + lOrR[k];
            int y = j + uOrD[k];
            // 判断是否越界
            if (heights[0].length <= y || heights.length <= x || x < 0 || y < 0) {
                continue;
            }
            if (heights[i][j] <= heights[x][y] && temp[x][y] != 1) {
                dfs(heights, temp, x, y);
            }
        }

    }

    @Test
    public void main() {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
//        int[][] heights = {{2,1}, {1,2}};
        System.out.println(pacificAtlantic(heights).toString());
    }

}
