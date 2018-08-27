import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-07 21:21
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] index = new int[10];
        List<List<Integer>> lists = getList(index, k, n, 1);

        if(lists == null){
            lists = new ArrayList<List<Integer>>();
        }
        return lists;
    }

    private List<List<Integer>> getList(int[] index, int k, int n, int low) {
        if (k <= 0 || k * k / 2 - 1 > n || n <= 0) {
            return null;
        }

        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        if (k == 1 && n < 10 && index[n] == 0 && n >= low) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(n);
            lists.add(list);
            return lists;
        }

        out:
        for (int i = low; i <= Math.min(9, n); i++) {
            if (index[i] != 0) {
                continue;
            }
            int[] t = Arrays.copyOf(index, index.length);
            List<Integer> list = new ArrayList<Integer>();
            list.add(i);
            t[i]++;
            List<List<Integer>> temp = getList(t, k - 1, n - i, i + 1);

            if (temp == null || temp.size() == 0) {
                continue;
            }
            for (List<Integer> integers : temp) {
                if (integers.size() != k - 1) {
                    continue out;
                }
                integers.addAll(list);
                Collections.sort(integers);
                lists.add(integers);
            }
        }
        return lists;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combinationSum3(2, 18);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.printf(integer + " ");
            }
            System.out.println();
        }
    }

}
