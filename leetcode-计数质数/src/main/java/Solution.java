import java.util.ArrayList;
import java.util.List;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-28 16:37
 */
public class Solution {
    public int countPrimes(int n) {
        int count = 0;
        int[] num = new int[n];
        for (int i = 0; i < num.length; i++) {
            num[i] = i;
        }

        if (n <= 2) {
            return 0;
        }
        for (int i = 2; i < n; i++) {
            if (num[i] != 0) {
                count++;
            }
            int k = i;
            int m = 2;
            while (k * m < n) {
                num[k * m] = 0;
                m++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.countPrimes(10000);
        System.out.println(i);
    }


    public int batter(int n) {
        if (--n < 2) {
            return 0;
        }
        int m = (n + 1) / 2;
        int count = m;
        int k;
        int u = (int) ((Math.sqrt(n) - 1) / 2);
        boolean[] notPrime = new boolean[m];

        for (int i = 1; i <= u; i++) {
            if (!notPrime[i]) {
                for (k = (i + 1) * 2 * i; k < m; k += i * 2 + 1) {
                    if (!notPrime[k]) {
                        notPrime[k] = true;
                        count--;
                    }
                }
            }
        }
        return count;
    }
}
