package 数学题;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode883.java
 * @Description
 * @createTime 2022年04月26日 22:39:00
 */
public class LeetCode883 {

    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int xyArea = 0, yzArea = 0, zxArea = 0;
        for (int i = 0; i < n; i++) {
            int yzHeight = 0, zxHeight = 0;
            for (int j = 0; j < n; j++) {
                xyArea += grid[i][j] > 0 ? 1 : 0;
                yzHeight = Math.max(yzHeight, grid[j][i]);
                zxHeight = Math.max(zxHeight, grid[i][j]);
            }
            yzArea += yzHeight;
            zxArea += zxHeight;
        }
        return xyArea + yzArea + zxArea;
    }

}
