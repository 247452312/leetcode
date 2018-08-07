/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-07-25 09:04
 */
public class Solution {

    public String longestPalindrome(String s) {
        if(s==null||s.length()==0) {
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
}
