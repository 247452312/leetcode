import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-29 20:24
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        } else if (n == 1) {
            ArrayList<String> objects = new ArrayList<>();
            objects.add("()");
            return objects;
        }
        List<String> sb = ggGe(n);
        return sb;

    }

    private List<String> ggGe(int n) {
        Set<String> list = new HashSet<>();
        list.add("()");
        for (int i = 0; i < n - 1; i++) {
            list = addN(list);
        }
        Set<String> finalList = list;
        return new ArrayList<String>() {{
            addAll(finalList);
        }};
    }

    private Set<String> addN(Set<String> list) {
        Set<String> list_temp = new HashSet<>();
        for (String s : list) {
            for (int i = 0; i < s.length(); i++) {
                StringBuilder string = new StringBuilder();
                string.append(s, 0, i);
                string.append("()");
                string.append(s, i, s.length());
                list_temp.add(string.toString());
            }
        }
        return list_temp;
    }


    public static void main(String[] args) {
        List<String> list = new Solution().generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.size());
    }
}
