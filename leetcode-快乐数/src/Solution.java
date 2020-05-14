import java.util.ArrayList;
import java.util.List;

/**
 * @author uhyils <247452312@qq.com>
 * @date 文件创建日期 2020年04月30日 14时34分
 */
public class Solution {
    public boolean isHappy(int n) {
        List<Integer> integers = decomposeInt(n);
        List<Integer> mark = new ArrayList<>();


        while (!mark.contains(n)) {
            mark.add(n);
            n = 0;
            for (Integer integer : integers) {
                n += integer * integer;
            }
            if (n == 1) {
                return true;
            }
            integers = decomposeInt(n);
        }
        return false;
    }

    private List<Integer> decomposeInt(int n) {
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            int i = n % 10;
            list.add(i);
            n = n / 10;
        }

        return list;
    }


    public static void main(String[] args) {
        boolean happy = new Solution().isHappy(83);
        System.out.println(happy);
    }
}
