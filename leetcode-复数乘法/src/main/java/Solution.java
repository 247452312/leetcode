/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-02 11:29
 */
public class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] sa = a.split("\\+");
        String[] sb = b.split("\\+");

        Integer a1 = Integer.parseInt(sa[0]);
        Integer a2 = Integer.parseInt(sa[1].substring(0, sa[1].length() - 1));
        Integer b1 = Integer.parseInt(sb[0]);
        Integer b2 = Integer.parseInt(sb[1].substring(0, sb[1].length() - 1));

        Integer r1 = a1 * b1 - a2 * b2;

        Integer r2 = a1 * b2 + b1 * a2;

        return r1 + "+" + r2 + "i";

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = solution.complexNumberMultiply("1+-1i", "0+0i");
        System.out.println(s);
    }
}
