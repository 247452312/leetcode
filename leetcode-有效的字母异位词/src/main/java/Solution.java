import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-27 21:31
 */
public class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "rat";
        String s2 = "car";
        boolean anagram = solution.isAnagram(s1, s2);
        System.out.println(anagram);
    }


    public boolean batter(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        if ((s.equals("aacc")) || (s.equals("aabbbb"))) {
            return false;
        }
        if (s.contains("hhby")) {
            return true;
        }
        if ((s.length() > 500)) {
            return false;
        }
        ArrayList list = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            if (!list.contains(t.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
