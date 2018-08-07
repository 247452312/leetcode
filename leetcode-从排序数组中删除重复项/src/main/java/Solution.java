/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-03 08:38
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int position = 0;
        for (int i = 0; i < nums.length; i++) {
            boolean b = false;
            for (int i1 = 0; i1 < position; i1++) {
                if (nums[i] == nums[i1]) {
                    b = true;
                }
            }
            if (b == false) {
                nums[position] = nums[i];
                position++;
            }
        }
        return position ;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] l = new int[]{0, 0, 1, 2, 2, 3, 4, 5, 6, 7};
        int i = solution.removeDuplicates(l);
        System.out.println(i);
        for (int i1 : l) {
            System.out.printf(i1 + " ");
        }
    }
}
