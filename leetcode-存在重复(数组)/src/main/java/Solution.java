/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-03 14:06
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null) {
            return false;
        }
        if (nums.length == 0) {
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{1, 2, 3, 1};
        boolean b = solution.containsDuplicate(ints);
        System.out.println(b);
    }
}
