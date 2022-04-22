package string;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode824.java
 * @Description 山羊拉丁文
 * @createTime 2022年04月21日 20:48:00
 */
public class LeetCode824 {

    public String toGoatLatin(String sentence) {
        Pattern pattern = Pattern.compile("^[aeiouAEIOU]");
        String[] strArr = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            Matcher matcher = pattern.matcher(strArr[i]);
            if (matcher.find()) {
                sb.append(strArr[i]).append("ma").append(getA(i + 1)).append(" ");
            } else {
                sb.append(strArr[i].substring(1)).append(strArr[i].charAt(0)).append("ma").append(getA(i + 1)).append(" ");
            }
        }

        return sb.toString().trim();

    }

    public String getA(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append("a");
            n--;
        }
        return sb.toString();
    }

    @Test
    public void main() {

        System.out.println(toGoatLatin("I quick brown fox jumped over the lazy dog"));
    }
}
