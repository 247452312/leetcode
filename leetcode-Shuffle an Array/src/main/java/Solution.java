import java.util.Arrays;
import java.util.Random;

/**
 * 打乱一个没有重复元素的数组。
 * <p>
 * 示例:
 * <p>
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 * <p>
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 * <p>
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-28 15:21
 */
public class Solution {
    int[] num;
    int length;
    Random random = new Random();

    public Solution(int[] nums) {
        num = nums;
        length = nums.length;

    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return num;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] temp = Arrays.copyOf(num, num.length);
        for (int j = 0; j < temp.length; j++) {
            int i = random.nextInt(length);
            int t = temp[j];
            temp[j] = temp[i];
            temp[i] = t;
        }
        return temp;
    }


    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3});
        int[] shuffle = solution.shuffle();
        for (int i : shuffle) {
            System.out.printf(" " + i);
        }
        System.out.println();
        int[] reset = solution.reset();
        for (int i : reset) {
            System.out.printf(" " + i);
        }
        System.out.println();
        int[] shuffle2 = solution.shuffle();
        for (int i : shuffle2) {
            System.out.printf(" " + i);
        }

    }
}
