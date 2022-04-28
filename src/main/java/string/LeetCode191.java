package string;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode191.java
 * @Description 位1的个数 -- 二进制中有多少个1
 * @createTime 2022年04月25日 23:38:00
 */
public class LeetCode191 {
    public int hammingWeight(int n) {
        String tmp = Integer.toBinaryString(n).replaceAll("0", "");
        return tmp.trim().length();
    }

}
