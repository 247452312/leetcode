/**
 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
 * <p>
 * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 *
 * @author 商轶龙 <247452312@qq.com>
 * @date 文件创建日期 2018-09-18 17:03
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] split = str.split(" ");
        if (pattern.length() != split.length) {
            return false;
        }
        String[] strings = new String[128];
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String string = strings[c];
            if (string == null || string.length() == 0) {
                strings[c] = split[i];
            } else {
                if (split[i].equals(string)) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        for (int i = 0; i < strings.length; i++) {
            for (int k = i + 1; k < strings.length; k++) {
                if (strings[i] != null && strings[i].equals(strings[k])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = new Solution().wordPattern("abab", "start end start end");
        System.out.println(b);
    }
}
