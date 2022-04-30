package arrary;

import org.junit.Test;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode231.java
 * @Description 2的幂
 * @createTime 2022年04月29日 23:50:00
 */
public class LeetCode231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        while (n > 0) {
            if (n % 2 != 0) {
                return false;
            }
            n = n / 2;
            if (n == 1) return true;
        }
        return true;
    }

}
