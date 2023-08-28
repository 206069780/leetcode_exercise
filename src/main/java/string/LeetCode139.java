package string;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LeetCode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        for (int i = 0; i < wordDict.size(); i++) {

            s = s.replace(wordDict.get(i), "");
        }

        return s.length() > 0 ? false : true;
    }

    @Test
    public void test(){
        String s1 = "LeetCode";
        List<String> list = Arrays.asList("Leet", "Code");
        wordBreak(s1, list);
    }
}
