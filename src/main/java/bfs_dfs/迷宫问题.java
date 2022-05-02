package bfs_dfs;

import org.junit.Test;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName 迷宫问题.java
 * @Description 搜索算法学习
 * @createTime 2022年04月23日 22:04:00
 */
public class 迷宫问题 {

    @Test
    public void main() {
        // 矩阵初始化
        int[][] img = imgInit(8);
        showImg(img);
        System.out.println("-----------------------------");
        boolean res = bfs(img, 4, 5);
        System.out.println(res);
        showImg(img);

    }

    // 打印矩阵
    public void showImg(int[][] img) {
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                System.out.print(img[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 初始化矩阵
    public int[][] imgInit(int n) {
        int[][] img = new int[n][n];
        for (int i = 0; i < n; i++) {
            img[0][i] = 1;
            img[i][0] = 1;
            img[n - 1][i] = 1;
            img[i][n - 1] = 1;
        }

        return img;
    }

    // 路径查找
    public boolean bfs(int[][] arr, int i, int j) {
        if (arr[6][6] == 2) {
            return true;
        }
        if (arr[i][j] == 0) {
            arr[i][j] = 2;
            // 递归查找上下左右是否可以可以前进
            if (bfs(arr, i + 1, j) || bfs(arr, i - 1, j) || bfs(arr, i, j - 1) || bfs(arr, i, j + 1)) {
                return true;
            } else {
                arr[i][j] = 0;
                return false;
            }
        }
        return false;
    }
}
