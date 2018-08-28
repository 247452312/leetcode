/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-28 14:05
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int tempMax = 0;
        int maxnum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            maxnum = maxnum > nums[i] ? maxnum : nums[i];
            tempMax += nums[i];
            if (tempMax <= 0) {
                tempMax = 0;
            } else {
                if (max < tempMax) {
                    max = tempMax;
                }
            }


        }
        return Math.max(max, maxnum);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, -1, -2, -1};
        int i = solution.maxSubArray(nums);
        System.out.println(i);
    }


    public static int batter(int[] nums) {
        int sum = 0;
        int sumMax = nums[0];
        for (int i : nums) {
            sum += i;
            sumMax = Math.max(sumMax, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return sumMax;
    }
}
