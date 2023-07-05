package bfs_dfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode1162.java
 * @Description 地图分析  你现在手里有一份大小为 n x n 的 网格 grid，上面的每个 单元格 都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地。
 * <p>
 * 请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的，并返回该距离。如果网格上只有陆地或者海洋，请返回 -1。
 * <p>
 * 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个单元格之间的距离是 |x0 - x1| + |y0 - y1| 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/as-far-from-land-as-possible
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @EMAIL: fudaopin@huawei.com
 * @createTime 2022年06月26日 15:45:00
 */
public class LeetCode1162 {

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, bfs(i, j, n, grid));
            }
        }
        return ans;
    }

    private int bfs(int x, int y, int n, int[][] grid) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> d = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        d.addLast(new int[]{x, y});
        map.put(x * n + y, 0);
        while (!d.isEmpty()) {
            int[] poll = d.pollFirst();
            int dx = poll[0], dy = poll[1];
            int step = map.get(dx * n + dy);
            if (grid[dx][dy] == 1) {
                return step;
            }
            for (int[] di : dirs) {
                int nx = dx + di[0], ny = dy + di[1]; // 移动
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) { // 超出范围， 进行下一步
                    continue;
                }
                int key = nx * n + ny;
                if (map.containsKey(key)) {
                    continue;
                }
                d.addLast(new int[]{nx, ny});
                map.put(key, step + 1);
            }

        }
        return -1;
    }
}
