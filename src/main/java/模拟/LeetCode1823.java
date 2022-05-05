package 模拟;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode1823.java
 * @Description 找出游戏的获胜者
 * @createTime 2022年05月04日 02:51:00
 */
public class LeetCode1823 {
    public int findTheWinner(int n, int k) {
        Queue<Integer> persons = new LinkedList();
        for (int i = 1; i <= n; i++) {
            persons.add(i);
        }
        int count = 1;
        while (persons.size() > 1) {

            Integer person = persons.poll();
            if (count % k != 0) {
                persons.add(person);
            }
            count++;
        }
        return persons.poll();
    }

    @Test
    public void main() {
        System.out.println(findTheWinner(3, 1));
    }


}
