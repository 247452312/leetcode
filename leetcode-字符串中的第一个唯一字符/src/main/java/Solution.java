import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 案例:
 * <p>
 * s = "leetcode"
 * 返回 0.
 * <p>
 * s = "loveleetcode",
 * 返回 2.
 * <p>
 * <p>
 * 注意事项：您可以假定该字符串只包含小写字母。
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-27 20:58
 */
public class Solution {
    public int firstUniqChar(String s) {
        List<Character> characters = new ArrayList<>();
        List<Character> char2 = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (Character aChar : chars) {
            if (characters.contains(aChar)) {
                characters.remove(aChar);
                char2.add(aChar);
            } else if (char2.contains(aChar)) {
                continue;
            } else {
                characters.add(aChar);
            }
        }
        if (characters.size() == 0) {
            return -1;
        }
        return s.indexOf(characters.get(0));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "leetcode";
        int i = solution.firstUniqChar(str);
        System.out.println(i);
    }


    public int batter(String s) {
        int result = -1;
        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c)) {
                result = result != -1 ? Math.min(result, index) : index;
            }
        }
        return result;
    }
}
