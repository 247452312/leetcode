/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-02 13:46
 */
public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[0]) {
                return nums[i];
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int min = solution.findMin(new int[]{5, 6, 7, 0, 1, 2});
        System.out.println(min);
    }
}
