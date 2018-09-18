/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-28 17:40
 */
public class Solution {

    public int reverseBits(int n) {
        int result = 0;
        int i = 0;
        while (i < 32) {
            int temp = n & 0x01;
            n = n >> 1;

            result = (result << 1) | temp;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.reverseBits(43261596);
        System.out.println(i);
    }

}
