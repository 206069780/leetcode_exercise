package string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

/**
 * @packageName: string
 * @program: leetcode_exercise
 * @className: leetcode003
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-08-06  21:25
 * @description: TODO
 **/
public class leetcode003 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0 || s.trim().length() == 0) {
            return 0;
        }
        return getMaxLen(s);
    }

    public int getMaxLen(String s) {

        int maxLen = 0;
        int p = 0, q = 0;
        Map<Character, Integer> res = new HashMap<>();
        while (q < s.length()) {
            if (res.containsKey(s.charAt(q))) {
                p = res.get(s.charAt(q)) + 1;
            }
            res.put(s.charAt(q), q);
            maxLen = max(maxLen, q - p + 1);
            ++q;
        }

        return maxLen;
    }

    @Test
    public void test() {
        int i = lengthOfLongestSubstring("null");
        System.out.println(i);
    }
}
