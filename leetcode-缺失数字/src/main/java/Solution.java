import java.util.Arrays;

/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-28 18:53
 */
public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == 0) {
                return 1;
            }
            if (nums[0] == 1) {
                return 0;
            }
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                return nums[i - 1] + 1;
            }
        }
        return nums[nums.length - 1] + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.missingNumber(new int[]{1, 2, 3, 3, 5});
        System.out.println(i);
    }
}
