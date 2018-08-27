import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-27 15:51
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        if (digits.length == 1 && digits[0] == 9) {
            return new int[]{1, 0};
        }
        int length = digits.length;
        if (digits[digits.length - 1] != 9) {
            digits[length - 1] += 1;
            return digits;
        } else {
            int[] ints = Arrays.copyOfRange(digits, 0, length - 1);
            int[] ints1 = plusOne(ints);
            int[] ints2 = new int[ints1.length + 1];
            for (int i = 0; i < ints1.length; i++) {
                ints2[i] = ints1[i];
            }
            return ints2;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] i = new int[]{9,9,8};
        int[] ints = solution.plusOne(i);
        for (int anInt : ints) {
            System.out.printf(" " + anInt);
        }
    }
}
