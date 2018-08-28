/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-27 21:45
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        String s1 = s.replaceAll("[^a-zA-Z0-9]", "");
        char[] chars = s1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] += 'a' - 'A';
            }
        }
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcc f a s fsa ,as,df ";
        boolean palindrome = solution.isPalindrome(s);
        System.out.println(palindrome);
    }

    public boolean batter(String s) {
        char[] sArray = s.toCharArray();
        int[] res = new int[sArray.length];
        int length = 0;
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] != ' ') {
                int gapB = sArray[i] - 'A';
                int gapS = sArray[i] - 'a';
                if (gapB >= 0 && gapB <= 25) {
                    res[length++] = gapB + 10;
                } else if (gapS >= 0 && gapS <= 25) {
                    res[length++] = gapS + 10;
                } else if (sArray[i] >= '0' && sArray[i] <= '9') {
                    res[length++] = sArray[i] - '0';
                }
            }
        }
        int start = 0;
        int end = length - 1;
        while (start < end) {
            if (res[start] != res[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
