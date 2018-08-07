/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-03 09:16
 */
public class Solution {
    public int maxProfit(int[] prices) {

        int low = 0;
        int profit = 0;
        boolean shareholding = false;

        for (int i = 0; i < prices.length - 1; i++) {
            if (shareholding) {
                if (prices[i + 1] < prices[i]) {
                    shareholding = false;
                    profit += prices[i] - low;
                }
            } else {
                if (prices[i] < prices[i + 1]) {
                    low = prices[i];
                    shareholding = true;
                }
            }
        }
        if (shareholding) {
            profit += prices[prices.length - 1] - low;
        }
        return profit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int i = solution.maxProfit(new int[]{0, 2, 3, 4, 5, 1, 1, 2, 1, 4, 5, 3});
        System.out.println(i);
    }
}
