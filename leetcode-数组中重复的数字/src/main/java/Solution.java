import java.util.HashMap;

/**
 * @author uhyils <247452312@qq.com>
 * @date 文件创建日期 2020年08月31日 13时43分
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);

        for (int num : nums) {
            if (map.containsKey(num)) {
                return num;
            } else {
                map.put(num, 1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int repeatNumber = new Solution().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
        System.out.println(repeatNumber);
    }
}
