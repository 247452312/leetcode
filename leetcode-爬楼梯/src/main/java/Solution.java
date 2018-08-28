/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-28 13:15
 */
public class Solution {

    public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }
        if (n <= 3) {
            return n;
        }
        int a = 1;
        int b = 1;
        while (--n != 0) {
            a = a + b;
            b = a - b;
        }
        return a;

    }
    //1->1  2 -> 1 + 1 3-> 1 + 2 4 ->1 + 3 + 1 5 -> 1 + 4 + 3  6 -> 1 + 5 + 6 + 1

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 5;
        int i = solution.climbStairs(k);
        System.out.println(i);
    }

}
