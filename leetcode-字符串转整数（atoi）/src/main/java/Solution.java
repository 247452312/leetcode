import java.util.ArrayList;
import java.util.List;

/**
 * 实现 atoi，将字符串转为整数。
 * <p>
 * 在找到第一个非空字符之前，需要移除掉字符串中的空格字符。如果第一个非空字符是正号或负号，选取该符号，并将其与后面尽可能多的连续的数字组合起来，这部分字符即为整数的值。如果第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 字符串可以在形成整数的字符后面包括多余的字符，这些字符可以被忽略，它们对于函数没有影响。
 * <p>
 * 当字符串中的第一个非空字符序列不是个有效的整数；或字符串为空；或字符串仅包含空白字符时，则不进行转换。
 * <p>
 * 若函数不能执行有效的转换，返回 0。
 * <p>
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。如果数值超过可表示的范围，则返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 * 因此返回 INT_MIN (−231) 。
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-27 22:07
 */
public class Solution {
    public int myAtoi(String str) {
        if (str.length() < 1) {
            return 0;
        }

        //过滤字符串开头空格
        int pos = 0;
        while (pos < str.length() && str.charAt(pos) == ' ') {
            pos++;
        }
        str = str.substring(pos, str.length());

        //过滤空串
        if ("".equals(str)) {
            return 0;
        }

        //数据为正或负 true为正
        boolean operator = true;

        String numString;

        //字符串开头非数字情况
        if (str.charAt(0) < '0' || str.charAt(0) > '9') {
            //非+或者-不合法返回0
            if (str.charAt(0) != '+' && str.charAt(0) != '-') {
                return 0;
            }
            //数字为负数
            if (str.charAt(0) == '-') {
                operator = false;
            }
            //获取数值
            numString = getNumStr(str.substring(1, str.length()));
        } else {
            numString = getNumStr(str);
        }


        //过滤数据部分为空串的情况
        if ("".equals(numString)) {
            return 0;
        }

        //过滤掉数据超出long的情况
        if (numString.length() > 10) {
            if (operator) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        //转化数值
        long num = Long.parseLong(numString);
        if (!operator) {
            num = -num;
        }

        //根据结果范围返回数值
        if (num < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (num > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) num;

    }

    /**
     * 截取字符串的开头数值
     *
     * @param s 字符串
     * @return 数值字符串
     */
    private String getNumStr(String s) {
        StringBuilder num = new StringBuilder();
        boolean isStart = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                if (isStart && s.charAt(i) == '0') {
                    continue;
                }
                isStart = false;
                num.append(s.charAt(i));
            } else {
                break;
            }
        }

        return num.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "words and 987";
        int i = solution.myAtoi(str);
        System.out.println(i);
    }

    public int batter(String str) {
        int index = 0;
        long out = 0;
        boolean positive = true;
        while (index < str.length() && str.charAt(index) == ' '){
            ++index;
        }
        if (index < str.length() && str.charAt(index) == '-'){
            positive = false;
            ++index;
        }
        else if (index < str.length() && str.charAt(index) == '+'){
            ++index;
        }
        while (index < str.length() && Character.isDigit(str.charAt(index))){
            out = out * 10 + str.charAt(index) - '0';
            if (out > Integer.MAX_VALUE){
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ++index;
        }
        return positive ? (int) out : (int) -out;
    }
}
