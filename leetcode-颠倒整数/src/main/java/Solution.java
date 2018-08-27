/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-27 18:50
 */
public class Solution {
    public int reverse(int x) {
        /*是不是复数*/
        boolean b = false;
        if (x < 0) {
            b = true;
            x = -x;
        }

        String s = String.valueOf(x);

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char ch = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = ch;
        }
        try {
            int i = Integer.parseInt(new String(chars));
            if (b) {
                return -i;
            } else {
                return i;
            }
        } catch (Exception e) {
            return 0;
        }


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = 1534236469;
        int reverse = solution.reverse(i);
        System.out.println(reverse);
    }

    public int batter(int x) {
        int next = x;
        /*
         pop:反转数——余数
          */
        int pop = 0;
        int result = 0;
        do {
            pop = next % 10;
            next /= 10;
            // 判断是否溢出

            // MIN: -2147483648
            if (result < Integer.MIN_VALUE / 10 || result * 10 == Integer.MAX_VALUE && pop < -8) {
                return 0;
            }
            // MAX:  2147483647
            if (result > Integer.MAX_VALUE /10 || result * 10 == Integer.MAX_VALUE && pop > 7) {
                return 0;
            }
            result = result * 10 + pop;
        }
        while (next != 0);
        return result;
    }

}
