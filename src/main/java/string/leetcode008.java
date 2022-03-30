package string;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName leetcode008.java
 * @Description 字符串转换整数
 * @createTime 2022年03月26日 00:11:00
 */
public class leetcode008 {
    public int myAtoi(String s) {
        //  去掉前后的空格
        String str = s.trim();
        if (str.length() < 1) return 0;
        long ans = 0;
        int index = 0;
        int sign = 1;
        boolean switched = true;
        char[] chars = str.toCharArray();

        //判断结果正负
        if (chars[index] == '-' && switched) {
            // 存在 -
            sign = -1;
            ++index;
            switched = false;
        } else if (chars[index] == '+' && switched) {
            // 存在 +
            ++index;
            switched = false;
        } else {
            // 第一个字符 不是 - 也不是 +
            switched = false;
        }

        for (; index < chars.length; index++) {
            char c = chars[index];
            if (!Character.isDigit(c)) {
                break;
            }
            ans = ans * 10 + Integer.parseInt(String.valueOf(c));

            if (ans > Integer.MAX_VALUE) {
                if (sign == -1) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }

        }
        return (int) ans * sign;
    }

    int myAtoiCopy(String s) {
        String pattern = "^\\s*([+-]?\\d+)";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(s);
        if (!m.find()) return 0;

        BigDecimal ans = new BigDecimal(m.group(1));
        if (ans .compareTo(new BigDecimal(Integer.MAX_VALUE)) >0) {
            return Integer.MAX_VALUE;
        }
        if (new BigDecimal(String.valueOf(Integer.MIN_VALUE)).compareTo(ans)>0) {
            return Integer.MIN_VALUE;
        }
        return Integer.parseInt(String.valueOf(ans));
    }

    @Test
    public void main() {

        System.out.println(myAtoiCopy(" 121231"));
    }

}
