import java.util.*;

/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-07-24 18:25
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) {
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
        }
        return res;
    }

    public int[] batter(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) {
            return res;
        }

        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
            if (min > nums[i]) {
                min = nums[i];
            }
        }

        int[] index = new int[max - min + 1];
        target = target;
        int other = 0;
        for (int i = 0; i < nums.length; i++) {
            other = target - nums[i];
            if (other < min || other > max) {
                continue;
            }
            if (index[other - min] > 0) {
                res[0] = index[other - min] - 1;
                res[1] = i;
                return res;
            }
            index[nums[i] - min] = i + 1;
        }
        return res;
    }


}
