import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例:
 * <p>
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * @author uhyils <247452312@qq.com>
 * @date 文件创建日期 2019年02月01日 17时46分
 */
public class Solution {
    public boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(n);
        int s = n;
        while (true) {
            s = getNextNum(s);
            if (s == 1) {
                return true;
            }
            if (list.contains(s)) {
                return false;
            }
            list.add(s);

        }
    }

    private int getNextNum(int s) {
        int sum = 0;
        while (s != 0) {
            int i = s % 10;
            s /= 10;
            sum += (int) Math.pow(i, 2);

        }
        return sum;
    }

    public static void main(String[] args) {
        boolean happy = new Solution().isHappy(19);
        System.out.println(happy);
    }


    public boolean niuB(int num) {
        if(num < 10) {
            return num == 1 || num == 7;
        }
        int n = num;
        int b = 0;
        while(n > 0) {
            b += (n % 10) * (n % 10);
            n = n / 10;
        }
        return isHappy(b);
    }
}
