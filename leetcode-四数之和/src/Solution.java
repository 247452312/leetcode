import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author uhyils <247452312@qq.com>
 * @date 文件创建日期 2020年04月30日 15时14分
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                for (int i2 = i1 + 1; i2 < nums.length; i2++) {
                    for (int i3 = i2 + 1; i3 < nums.length; i3++) {
                        if (nums[i] + nums[i1] + nums[i2] + nums[i3] == target) {
                            int[] temp = new int[4];
                            temp[0] = nums[i];
                            temp[1] = nums[i1];
                            temp[2] = nums[i2];
                            temp[3] = nums[i3];
                            Arrays.sort(temp);
                            boolean canInsert = true;
                            for (List<Integer> integers : list) {
                                if (integers.get(0) == temp[i] && integers.get(1) == temp[i1] && integers.get(2) == temp[i2] && integers.get(3) == temp[i3]) {
                                    canInsert = false;
                                    break;
                                }
                            }
                            if (canInsert != true) {
                                continue;
                            }
                            List<Integer> lists = new ArrayList<>();
                            lists.add(temp[0]);
                            lists.add(temp[1]);
                            lists.add(temp[2]);
                            lists.add(temp[3]);
                            list.add(lists);
                        }
                    }
                }
            }

        }
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.printf(integer.toString());
            }
            System.out.println();
        }

    }


}
