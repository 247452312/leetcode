
/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-07-24 18:10
 */
public class Solution {

    public boolean lemonadeChange(int[] bills) {
        int m5 = 0;
        int m10 = 0;

        for (int bill : bills) {
            if (bill == 5) {
                m5++;
                continue;
            }
            if (bill == 10) {
                if (m5 >= 1) {
                    m5--;
                    m10++;
                    continue;
                } else {
                    return false;
                }
            }
            if (bill == 20) {
                int temp = bill;
                if (m10 >= 1) {
                    temp -= 10;
                    m10--;
                }
                if (temp == 10 && m5 >= 1) {
                    m10++;
                    m5--;
                    continue;
                } else if (temp == 20 && m5 >= 3) {
                    m5 -= 3;
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] i = new int[]{5,5,10,10,20};
        boolean b = new Solution().lemonadeChange(i);
        System.out.println(b);
    }
}
