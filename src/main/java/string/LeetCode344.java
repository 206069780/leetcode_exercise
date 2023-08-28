package string;

import org.junit.Test;

public class LeetCode344 {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        for (; l < r; l++, r--) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
        }

        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]);
        }
    }

    @Test
    public void test(){
        String s = "hello word";
        String[] ss = new String[]{s};
        for (String sss:
             ss) {
            System.out.println(sss);

        }

    }
}
