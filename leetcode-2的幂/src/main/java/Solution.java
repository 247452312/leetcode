/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-02 10:04
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n = n >> 1;
            if (n == 1) {
                return true;
            }
        }
        return false;

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean powerOfTwo = solution.isPowerOfTwo(0);
        System.out.println(powerOfTwo);
    }

}
