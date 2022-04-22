package 模拟;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName 最常见的单词819.java
 * @Description 最常见的单词
 * @createTime 2022年04月17日 22:18:00
 */
public class 最常见的单词819 {
    public String mostCommonWord(String paragraph, String[] banned) {

        int maxCnt = Integer.MIN_VALUE;
        String strMaxStr = "";
        Map<String, Integer> tmpMap = new HashMap<>();
        List<String> bandedList = List.of(banned);

        String[] strArr = paragraph.replaceAll("[,.?!;']", " ")
                .toLowerCase().replaceAll("  "," ")
                .split(" ");

        for (String s : strArr) {
            // 禁用列表
            if (bandedList.contains(s)) {
                continue;
            }
            // 将字符放入tmp并计数
            if (tmpMap.containsKey(s)) {
                tmpMap.put(s, tmpMap.get(s) + 1);
            } else {
                tmpMap.put(s, 1);
            }
            // 每次维持出现最多的字符
            if (tmpMap.get(s) > maxCnt) {
                strMaxStr = s;
                maxCnt = Math.max(tmpMap.get(s),maxCnt);
            }
        }
        return strMaxStr;
    }

    @Test
    public void main() {
        String s ="j. t? T. z! R, v, F' x! L; l! W. M; S. y? r! n; O. q; I? h; w. t; y; X? y, p. k! k, h, J, " +
                "r? w! U! V; j' u; R! z. s. T' k. P? M' I' j! y. P, T! e; X. w? M! Y, X; G; d, X? S' F, K? V, " +
                "r' v, v, D, w, K! S? Q! N. n. V. v. t? t' x! u. j; m; n! F, V' Y! h; c! V, v, X' X' t? n; N' " +
                "r; x. W' P? W; p' q, S' X, J; R. x; z; z! G, U; m. P; o. P! Y; I, I' l' J? h; Q; s? U, q" +
                ", x. J, T! o. z, N, L; u, w! u, S. Y! V; S? y' E! O; p' X, w. p' M, h! R; t? K? Y' z? T? w; " +
                "u. q' R, q, T. R? I. R! t, X, s? u; z. u, Y, n' U; m; p? g' P? y' v, o? K? R. Q? I! c, X, x. r' " +
                "u! m' y. t. W; x! K? B. v; m, k; k' x; Z! U! p. U? Q, t, u' E' n? S' w. y; W, x? r." +
                " p! Y? q, Y. t, Z' V, S. q; W. Z, z? x! k, I. n; x? z; V? s! g, U; E' m! Z? y' x? " +
                "V! t, F. Z? Y' S! z, Y' T? x? v? o! l; d; G' L. L, Z? q. w' r? U! E, H. C, Q! O? w! s? w' D. R, Y" +
                "? u. w, N. Z? h. M? o, B, g, Z! t! l, W? z, o? z, q! O? u, N; o' o? V; S! z; q! q. o, t! " +
                "q! w! Z? Z? w, F? O' N' U' p? r' J' L; S. M; g' V. i, P, v, v, f; W? L, y! i' z; L? w. v, s! P?";

        String[] banded = {"m","q","e","l","c","i","z","j","g","t","w","v","h","p","d","b","a","r","x","n"};
        System.out.println(mostCommonWord(s, banded));
    }
}
