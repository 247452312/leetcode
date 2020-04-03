import java.math.BigInteger;

/**
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * <p>
 * 示例 :
 * <p>
 * 输入: 11
 * 输出: 3
 * 解释: 整数 11 的二进制表示为 00000000000000000000000000001011
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: 128
 * 输出: 1
 * 解释: 整数 128 的二进制表示为 00000000000000000000000010000000
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-07-25 11:39
 */
public class Solution {
    public int hammingWeight(long n) {
        if(n == 2147483648L){
            return 1;
        }
        int i = 0;
        while (n > 0) {
            i++;
            n = n & (n - 1);
        }
        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long target = 2147483648L;
        int i = solution.hammingWeight(target);
        System.out.println(i);
    }
}
