/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-07-25 09:04
 */
public class Solution {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String s1 = s.replaceAll("", "#");
        int length1 = s1.length();
        int length = 1;
        String maxStr = "";

        f:
        for (int i = 0; i < length1; i++) {
            int k = 0;
            w:
            while (true) {
                k++;
                if (k <= i && k + i < length1 && s1.charAt(i - k) == s1.charAt(i + k)) {
                    if (k * 2 + 1 > length) {
                        length = k * 2 + 1;
                        maxStr = s1.substring(i - k, i + k);
                    }
                } else {
                    break w;
                }
            }
        }
        return maxStr.replaceAll("#", "");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String abcba = solution.longestPalindrome("abcba");
        System.out.println(abcba);
    }


    public static String batter(String s) {
        if (s.length() <= 1) {
            return s;
        }
        //开始和结束位置
        int[] range = new int[]{0, 1};
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            //可以加速查找
            i = helper(ca, range, i);
        }
        return s.substring(range[0], range[1]);
    }

    private static int helper(char[] ca, int[] range, int index) {
        int lo = index, hi = index;
        //往前找到第一个不一样的地方
        while (hi < ca.length - 1 && ca[hi] == ca[hi + 1]) {
            hi++;
        }
        //下一个搜索的位置
        int ret = hi;
        //从两边对比看是否一致
        while (hi < ca.length - 1 && lo > 0 && ca[hi + 1] == ca[lo - 1]) {
            hi++;
            lo--;
        }
        //如果大于最长的那个
        if (hi - lo + 1 > range[1] - range[0]) {
            range[0] = lo;
            range[1] = hi + 1;
        }
        //返回下次寻找地址
        return ret;
    }
}
