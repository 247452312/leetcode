/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author uhyils <247452312@qq.com>
 * @date 文件创建日期 2020年03月25日 15时25分
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        int sIndex = s.length();
        int pIndex = p.length();
        out:
        while (sIndex >= 0 && pIndex >= 0) {
            if (pIndex - 1 >=0 && p.charAt(pIndex - 1) == '*') { //如果这一位是*
                in:
                for (int i = sIndex; i < s.length(); i++) {
                    if (s.charAt(i) == p.charAt(pIndex) || p.charAt(pIndex) == '.') { //如果匹配成功单个字符->匹配下一个
                        continue in;
                    }
                    // 如果匹配不成功,因为是* 不计算匹配失败,p+=2 s跳入下一位
                    sIndex = i;
                    pIndex += 2;
                    continue out;
                }
                sIndex = s.length();
                pIndex += 2;
                continue out;
            }
            if (p.charAt(pIndex) == s.charAt(sIndex) || p.charAt(pIndex) == '.') { //单个字符匹配成功
                pIndex++;
                sIndex++;
            } else { //单个字符匹配失败
                return false;
            }
        }
        if (sIndex == s.length() && pIndex == p.length()) {
            return true;
        }
        String substring = p.substring(pIndex);
        if (substring.split("\\*").length == substring.length() / 2) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*ip*.";
        boolean match = new Solution().isMatch(s, p);
        System.out.println(match);

    }
}
