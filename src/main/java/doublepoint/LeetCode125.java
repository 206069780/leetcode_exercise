package doublepoint;

import org.junit.Test;

import java.util.Locale;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode125.java
 * @Description 验证回文串
 * @createTime 2022年03月27日 14:19:00
 */
public class LeetCode125 {

    public boolean isPalindrome(String s) {

        String str = s.toLowerCase()
                .replaceAll("[^a-z0-9]", "");
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }


        }
        return true;
    }


    @Test
    public void Test() {
        String str = "cbb";
        System.out.println(this.isPalindrome(str));
    }

}
