
import java.util.ArrayList;
import java.util.List;

/**
 * 报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n ，输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-28 08:30
 */
public class Solution {

    public String countAndSay(int n) {

        String temp = "";
        for (int i = 1; i <= n; i++) {
            temp = getLast(temp);
        }
        return temp;
    }

    public final String k = "";

    public String getLast(String n) {
        if (k.equals(n)) {
            return "1";
        }
        char[] chars = n.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < chars.length) {
            int count = 1;
            while (i < chars.length - 1) {
                if (chars[i] == chars[i + 1]) {
                    i++;
                    count++;
                } else {
                    break;
                }
            }
            sb.append(count);
            sb.append(chars[i]);
            i++;

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.countAndSay(5);
        System.out.println(s);
    }

}
