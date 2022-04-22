import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName 字典序排序.java
 * @Description TODO
 * @createTime 2022年04月18日 19:03:00
 */
public class 字典序排序 {
    public List<Integer> lexicalOrder(int n) {
        List<String> tmp = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            tmp.add(i + "");
        }
        tmp.sort(String::compareTo);
        return tmp.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    @Test
    public void main(){
        System.out.println(lexicalOrder(14));
    }
}
