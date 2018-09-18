import java.util.ArrayList;
import java.util.List;

/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-28 18:11
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> lists = new ArrayList<>();
        if (numRows == 0) {
            return lists;
        }
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        lists.add(list1);

        for (int i = 2; i <= numRows; i++) {
            List<Integer> next = getNext(lists.get(i - 2));
            lists.add(next);
        }
        return lists;

    }


    public List<Integer> getNext(List<Integer> list) {
        List<Integer> list1 = new ArrayList<>(list.size() + 1);
        list1.add(1);
        for (int i = 0; i < list.size() - 1; i++) {
            list1.add(list.get(i) + list.get(i + 1));
        }
        list1.add(1);

        return list1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> generate = solution.generate(5);
        for (List<Integer> list : generate) {
            for (Integer integer : list) {
                System.out.printf(" " + integer);
            }
            System.out.println();
        }
    }
}
