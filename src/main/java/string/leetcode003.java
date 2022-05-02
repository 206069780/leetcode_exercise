package string;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.max;

/**
 * @packageName: string
 * @program: leetcode_exercise
 * @className: leetcode003
 * @author: Mr.FU
 * @Email: fudaopin@gmail.com
 * @createDate: 2021-08-06  21:25
 * @description:
 **/
public class leetcode003 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.equals("")||s.equals(" ") ) {
            return 1;
        }
        return getMaxLen(s);
    }

    public int getMaxLen(String str) {
        int ans = Integer.MIN_VALUE;
        int start = 0;
        Set<Character> characterSet = new HashSet<>();
        for (int i=0;i<str.length();i++) {
            while (characterSet.contains(str.charAt(i))) {
                characterSet.remove(str.charAt(start));
                start++;
            }
            characterSet.add(str.charAt(i));
            ans = Math.max(i - start+1, ans);
        }
        return ans;

    }

    @Test
    public void test() {
        int i = lengthOfLongestSubstring("pwwkew");
        System.out.println(i);
    }
}
