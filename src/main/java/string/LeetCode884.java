package string;

import org.junit.Test;

import java.util.*;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName LeetCode884.java
 * @Description
 * @createTime 2022年04月27日 23:42:00
 */
public class LeetCode884 {

    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> ans = new LinkedList<>();
        Map<String, Integer> tmpMap = new HashMap<>();
        getStrMap(s1, tmpMap);
        getStrMap(s2, tmpMap);
        tmpMap.forEach((k,v)->{
            if (v == 1) {
                ans.add(k);
            }
        });

        return ans.toArray(new String[ans.size()]);
    }

    private void getStrMap(String s2, Map<String, Integer> tmpMap) {
        String[] strArr = s2.split(" ");
        for (String s : strArr) {
            tmpMap.put(s, tmpMap.getOrDefault(s, 0) + 1);
        }
    }

    @Test
    public void main() {
        String s1 = "this apple is sweet", s2 = "this apple is sour";
        Arrays.stream(uncommonFromSentences(s1, s2)).forEach(System.out::println);
    }


}
