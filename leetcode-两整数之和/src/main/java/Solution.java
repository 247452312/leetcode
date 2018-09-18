/**
 * 不使用运算符 + 和-，计算两整数a 、b之和。
 * <p>
 * 示例：
 * 若 a = 1 ，b = 2，返回 3。
 * <p>
 * 致谢：
 * 特别感谢 @fujiaozhu 添加这道问题并创建测试用例。
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-29 20:38
 */
public class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            a++;
            b--;
        }
        return a;
    }

    public static void main(String[] args) {
        int sum = new Solution().getSum(1, 3);
        System.out.println(sum);

    }
}
