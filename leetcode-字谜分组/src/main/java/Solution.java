import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-29 11:58
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return lists;
        }
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String ch = new String(chars);
            if (map.containsKey(ch)) {
                map.get(ch).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(ch, list);
            }
        }
        for (String s : map.keySet()) {
            List<String> list = new ArrayList<>();
            List<Integer> iList = map.get(s);
            for (Integer integer : iList) {
                list.add(strs[integer]);
            }
            lists.add(list);
        }
        return lists;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.groupAnagrams(new String[]{"abcc", "bacc","bb"});
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.printf(" " + s);
            }
            System.out.println();
        }
    }
}
