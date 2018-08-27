import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-27 15:04
 */
public class Solution {

    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (Integer num : nums) {
            if (list.contains(num)) {
                list.remove(num);
            } else {
                list.add(num);
            }
        }
        return list.get(0);
    }

    public int batter(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int rst = 0;
        for (int aA : nums) {
            rst ^= aA;
        }
        return rst;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ii = new int[]{4, 1, 2, 1, 2};
        int i = solution.singleNumber(ii);
        System.out.println(i);
    }
}
