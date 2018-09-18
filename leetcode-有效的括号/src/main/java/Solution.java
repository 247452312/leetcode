import java.util.ArrayList;

/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-28 18:49
 */
public class Solution {
    public boolean isValid(String s) {
        int top = -1;
        ArrayList<Character> a = new ArrayList<Character>();
        for (char c : s.toCharArray()) {
            if (top == -1) {
                top++;
                a.add(c);
            } else {
                if (c == ')' && a.get(top) == '(' || c == ']' && a.get(top) == '[' || c == '}' && a.get(top) == '{') {
                    a.remove(top);
                    top--;
                    continue;
                }
                if (c == ')' && a.get(top) != '(' || c == ']' && a.get(top) != '[' || c == '}' && a.get(top) != '{') {
                    return false;
                }
                top++;
                a.add(c);
            }
        }
        return top == -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean valid = solution.isValid("sf(fasd{sad}dasf)");
        System.out.println(valid);

    }
}
