package string;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode389.java
 * @Description 找不同
 * @createTime 2022年05月01日 19:43:00
 */
public class LeetCode389 {
    public char findTheDifference(String s, String t) {
        char[] tmp1 = s.toCharArray();
        char[] tmp2 = t.toCharArray();
        getCharmap(tmp1, tmp2);
        return  getCharmap(tmp1, tmp2);
    }

    public char getCharmap(char[] chars1, char[] chars2) {
        List<Character> ansList = new LinkedList<>();
        int ans = 0;
        for (char c : chars2) {
            ans ^= c;
        }
        for (char c: chars1       ) {
            ans ^= c;
        }
        return (char) ans;
    }

    @Test
    public void main() {
        String s = "a";
        String t = "aa";
        char c = findTheDifference(s, t);
        System.out.println(c);
    }
}
