/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-07-25 11:39
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(long n) {
        int i = 0;
        while (n > 0) {
            i++;
            n = n & (n - 1);
        }
        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long target = 9L;
        int i = solution.hammingWeight(target);
        System.out.println(i);
    }
}
