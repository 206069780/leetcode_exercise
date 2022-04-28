package string;

import org.junit.Test;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode868.java
 * @Description 二进制间距
 * @createTime 2022年04月24日 00:21:00
 */
public class LeetCode868 {

    public int binaryGap(int n) {
        char[] binChar = Integer.toBinaryString(n).toCharArray();
        int slow = Integer.toBinaryString(n).indexOf('1');
        int fast = slow + 1, res = 0;
        while (fast < binChar.length) {
            if (binChar[fast] == '1') {
                res = Math.max(fast - slow, res);
                slow = fast;
            }
            fast++;
        }
        return res;
    }

    public int binaryGap1(int n) {
        char[] binChar = Integer.toBinaryString(n).toCharArray();
        int res = 0;
        int index = Integer.MIN_VALUE;
        for (int i = 0; i < binChar.length; i++) {
            if (binChar[i] == '1') {
                res = Math.max(i - index, res);
                index = i;
            }
        }
        return res;
    }

    @Test
    public void main() {
        System.out.println(binaryGap1(100));

    }
}
