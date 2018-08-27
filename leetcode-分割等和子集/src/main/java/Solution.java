import java.util.HashMap;

/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-08 08:57
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        } else {
            int mark = sum / 2;
            for (int i = 0; i < nums.length; i++) {
                if (haveNum(nums, mark, i)) {
                    return true;
                }
            }
            return false;

        }
    }

    private boolean haveNum(int[] nums, int target, int length) {
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPartition(new int[]{1, 2, 3, 4}));
        System.out.println(solution.canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(solution.canPartition(new int[]{1, 5, 5, 11}));
        System.out.println(solution.canPartition(new int[]{1, 2, 3, 6}));

    }
}
