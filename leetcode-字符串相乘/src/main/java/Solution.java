/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * 说明：
 * <p>
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * <p>
 * Related Topics 数学 字符串
 * 👍 412 👎 0
 *
 * @author uhyils <247452312@qq.com>
 * @date 文件创建日期 2020年08月13日 09时01分
 */
public class Solution {

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "";
        }
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int chars1Length = num1.length();
        int chars2Length = num2.length();
        String[] result = new String[chars1Length * chars2Length];
        int k = 0, aZeroCount = 0, bZeroCount;

        for (int i = chars1Length - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            bZeroCount = 0;
            for (int j = chars2Length - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';

                String s = a * b + "";
                for (int l = 0; l < aZeroCount + bZeroCount; l++) {
                    s += "0";
                }
                result[k++] = s;
                bZeroCount++;

            }
            aZeroCount++;
        }
        StringBuilder resultString = new StringBuilder();
        int tempNum = 0;
        int index = 1;
        while (true) {
            boolean b = false;
            for (int i = 0; i < result.length; i++) {
                if (result[i].length() >= index) {
                    b = true;
                    tempNum += Integer.parseInt(result[i].substring(result[i].length() - index, result[i].length() - index + 1));
                }
            }
            if (b) {
                resultString.insert(0, tempNum % 10);
                tempNum /= 10;
                index++;
            } else {
                if (tempNum != 0) {
                    resultString.insert(0, tempNum);
                }
                break;
            }
        }
        return resultString.toString();
    }


    public static void main(String[] args) {
        String multiply = new Solution().multiply("0", "0");
        System.out.println(multiply);
    }
}
