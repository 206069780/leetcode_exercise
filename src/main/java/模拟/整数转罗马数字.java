package 模拟;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author FuDaoPin
 * @version 1.0.0
 * @ClassName 整数转罗马数字.java
 * @Description
 * @createTime 2022年04月21日 21:51:00
 */
public class 整数转罗马数字 {
    //I， V， X， L，C，D 和 M
    public String intToRoman(int num) {

        Map<Integer, String> tmp = new HashMap<>() {{
            put(1, "I");
            put(4, "IV");
            put(5, "V");
            put(9, "IX");
            put(10, "X");
            put(40, "XL");
            put(50, "L");
            put(100, "C");
            put(90, "XC");
            put(400, "CD");
            put(500, "D");
            put(900, "CM");
            put(1000, "M");
        }};
        StringBuilder sb = new StringBuilder();
        while (num - 1000 >= 0) {
            sb.append(tmp.get(1000));
            num-=1000;
        }
        while (num - 900 >= 0) {
            sb.append(tmp.get(900));
            num-=900;
        }
        while (num - 500 >= 0) {
            sb.append(tmp.get(500));
            num-=500;
        }
        while (num - 400 >= 0) {
            sb.append(tmp.get(400));
            num-=400;
        }
        while (num - 100 >= 0) {
            sb.append(tmp.get(100));
            num-=100;
        }
        while (num - 90 >= 0) {
            sb.append(tmp.get(90));
            num-=90;
        }
        while (num - 50 >= 0) {
            sb.append(tmp.get(50));
            num-=50;
        }
        while (num - 40 >= 0) {
            sb.append(tmp.get(40));
            num-=40;
        }
        while (num - 10 >= 0) {
            sb.append(tmp.get(10));
            num-=10;
        }
        while (num - 9 >= 0) {
            sb.append(tmp.get(9));
            num-=9;
        }
        while (num - 5 >= 0) {
            sb.append(tmp.get(5));
            num-=5;
        }
        while (num - 4 >= 0) {
            sb.append(tmp.get(4));
            num-=4;
        }
        while (num - 1 >= 0) {
            sb.append(tmp.get(1));
            num-=1;
        }
        return sb.toString();
    }

    @Test
    public void main() {
        System.out.println(intToRoman(11));
    }
}

