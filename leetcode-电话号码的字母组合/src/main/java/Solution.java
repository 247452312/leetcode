import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-29 19:28
 */
public class Solution {


    String[] a = new String[]{"", "", "abc", "def",
            "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuffer sb = new StringBuffer();

    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();

        if (digits.length() == 0) {
            return answer;
        }

        zuhe(digits, 0, answer);

        return answer;
    }

    private void zuhe(String digits, int n, List<String> answer) {
        if (n == digits.length()) {
            answer.add(sb.toString());
            return;
        }
        for (int i = 0; i < a[digits.charAt(n) - '0'].length(); i++) {
            sb.append(a[digits.charAt(n) - '0'].charAt(i));
            zuhe(digits, n + 1, answer);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> x = new Solution().letterCombinations("23");


        System.out.println(x.toString());
    }


    public List<String> batter(String digits) {
        List<String> r = new ArrayList<>();
        if (digits.length() == 0) {
            return r;
        }
        char[][] map = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };
        char[] s = digits.toCharArray();
        int[] idxs = new int[s.length];
        int len = 1;
        for (int i = 0; i < s.length; i++) {
            idxs[i] = s[i] - '2';
            len *= map[idxs[i]].length;
        }
        char[][] rs = new char[len][s.length];
        int l = len;
        for (int i = 0; i < s.length; i++) {
            int num = map[idxs[i]].length;
            int tmpl = l / num;
            for (int j = 0; j < len; j++) {
                rs[j][i] = map[idxs[i]][(j / tmpl) % num];
            }
            l = tmpl;
        }

        for (int i = 0; i < len; i++) {
            r.add(new String(rs[i]));
        }

        return r;
    }

}
