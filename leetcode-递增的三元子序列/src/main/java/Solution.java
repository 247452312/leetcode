/**
 * 给定一个未排序的数列，判断这个数列中是否存在长度为 3 的递增子序列。
 * <p>
 * 数学表达式如下:
 * 如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
 * 使得 第i+1项 < 第j+1项 < 第k+1项 ，返回 成功 ; 否则返回 失败 。
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: 成功
 * 示例 2:
 * 输入: [5,4,3,2,1]
 * 输出: 失败
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-29 12:55
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        //如果数列为空或长度小于3 则返回失败
        if (nums == null || nums.length < 3) {
            return false;
        }
        //寻找第一个相邻并后一个数字大于前一个数字的数列中的位置 记为k
        int k = 1;
        for (; k < nums.length; k++) {
            if (nums[k] > nums[k - 1]) {
                break;
            }
        }
        //如果得到的位置和数列的长度相等 则返回失败
        if (k == nums.length) {
            return false;
        }
        //将数列中第一个相邻并后一个数字大于前一个数字的两个数记录为a1和a2 其中 a2>a1
        int a1 = nums[k - 1];
        int a2 = nums[k];

        //从位置k处开始遍历数列,正在遍历的位置为i
        for (int i = k + 1; i < nums.length; i++) {
            // 数列第i个位置的数字和第i-1位置的数字对比,如果 后一个数字大于前一个
            if (nums[i] > nums[i - 1]) {
                //如果是第一次遍历,则返回成功
                if (i == k + 1) {
                    return true;
                }
                //否则
                else {
                    //如果后面的数大于a2 或者 前面的数大于a1 返回成功
                    if (nums[i] > a2 || nums[i - 1] > a1) {
                        return true;
                    }
                    //如果后面的数 大于a2 并 小于a1 则将a2 重新赋值为后面的数
                    if (nums[i] < a2 && nums[i] > a1) {
                        a2 = nums[i];
                    }
                    //如果后面的数小于a1 则 将前面的数和后面的数分别赋值给a1,a2
                    if (nums[i] < a1) {
                        a1 = nums[i - 1];
                        a2 = nums[i];
                    }
                }
            }
        }
        //返回失败
        return false;
    }

    public static void main(String[] args) {
        boolean b = new Solution().increasingTriplet(new int[]{5, 1, 5, 5, 2, 5, 4});
        System.out.println(b);
    }
}
