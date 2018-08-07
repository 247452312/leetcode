/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-02 14:35
 */
public class Solution {
    public int racecar(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 3) {
            return 2;
        }
        int count = 0;
        int position = 0;
        int speed = 1;
        while (true) {
            if (position == target) {
                return count;
            }
            if (position + speed > target && speed > 0) {
                return count + 2 + Math.min(racecar(position + speed - target), racecar(target - position));
            } else if (position + speed >= target && speed < 0) {
                count++;
                position += speed;
                speed = speed << 1;
            } else if (position + speed <= target && speed > 0) {
                count++;
                position += speed;
                speed = speed << 1;
            } else if (position + speed < target && speed < 0) {
                return count + 2 + Math.min(racecar(target - position - speed), racecar(position - target));
            }

        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int racecar = solution.racecar(5);
        System.out.println(racecar);
    }
}
