package 模拟;

import org.junit.Test;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode657.java
 * @Description 机器人能否返回原点
 * @EMAIL: fudaopin@huawei.com
 * @createTime 2022年07月11日 20:45:00
 */
public class LeetCode657 {

    @Test
    public void main() {
        System.out.println(judgeCircle("LL L RRR"));
    }

    public boolean judgeCircle(String moves) {
        int[] array = {0, 0};
        int[][] removed = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        char[] moveChars = moves.toCharArray();
        for (char character : moveChars) {
            record(character, array, removed);
        }
        return array[0] == 0 && array[1] == 0;

    }


    public void record(char c, int[] arr, int[][] removed) {
        switch (c) {
            case 'U':
                changePos(arr, removed[0]);
                break;
            case 'D':
                changePos(arr, removed[1]);
                break;
            case 'L':
                changePos(arr, removed[2]);
                break;
            case 'R':
                changePos(arr, removed[3]);
                break;
        }
    }

    public void changePos(int[] arr, int[] posRemoved) {
        arr[0] += posRemoved[0];
        arr[1] += posRemoved[1];
    }

}
