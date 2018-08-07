import java.util.Arrays;

/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-03 09:52
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length == 0 || k == nums.length) {
            return;
        }
        int length = nums.length;
        int[] copy = Arrays.copyOf(nums, length);
        for (int i = 0; i < length; i++) {
            int end = i + k;
            if (end > length - 1) {
                end = end % nums.length;
            }
            nums[end] = copy[i];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(ints, 3);
        for (int anInt : ints) {
            System.out.printf(anInt + " ");
        }
    }
}
