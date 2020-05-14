/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author uhyils <247452312@qq.com>
 * @date 文件创建日期 2020年04月30日 15时01分
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        int lastresult = result;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int i1 = nums[i] + nums[j] + nums[k];
                    int abs = Math.abs(i1 - target);
                    if (abs < lastresult) {
                        result = i1;
                        lastresult = abs;
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int i = new Solution().threeSumClosest(new int[]{1, 1, 1, 0}, -100);
        System.out.println(i);
    }
}
