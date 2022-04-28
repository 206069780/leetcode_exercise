package arrary;

import org.junit.Test;

import java.util.Stack;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode15.java
 * @Description 每日温度 -- 单调栈
 * @createTime 2022年03月30日 20:41:00
 */
public class LeetCode739 {
    /**
     * 单调栈
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {

        int[] ans = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && (temperatures[i] > temperatures[stack.peek()])) {
                ans[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }

    @Test
    public void main() {

        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        for (int i : dailyTemperatures(arr)) {
            System.out.print(i + " ");
        }
    }
}
