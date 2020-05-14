import java.util.ArrayList;
import java.util.List;

/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-07-24 18:57
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {

        int length = 0;
        int startPoint = 0;
        int size = 0;
        List<Character> list = new ArrayList<Character>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            int i = list.lastIndexOf(aChar);
            list.add(aChar);
            size++;
            if (i < startPoint) {
                length = Math.max(length, size - startPoint);
            } else {
                startPoint = i + 1;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        int abcabcbb = new Solution().le("bbtablud");
        System.out.println(abcabcbb);
    }

    public int le(String s) {
        int n = s.length(), ans = 0;
        // current index of character
        int[] index = new int[128];
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
