package string;

import org.junit.Test;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode28.java
 * @Description 实现 strStr()
 * @createTime 2022年04月18日 19:41:00
 */
public class LeetCode28 {
    public int strStr(String haystack, String needle) {
//        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
//        }

    }

    @Test
    public void main(){
        System.out.println(strStr("aaaab","aabb"));
    }
}
