import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 编写一个程序，找出第 n 个丑数。
 * <p>
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 *
 * @author uhyils <247452312@qq.com>
 * @date 文件创建日期 2019年02月01日 16时39分
 */
public class Solution {
    public int nthUglyNumber(int n) {
        int[] num = new int[n];
        num[0] = 1;
        int index2 = 0,index3 = 0,index5 = 0;
        int[] result=new int[n];
        result[0]=1;

        int begin = 1;
        while(begin<n){
            result[begin]=Math.min(result[index2]*2,Math.min(result[index3]*3,result[index5]*5));
            if(result[begin]==result[index2]*2) index2++;
            if(result[begin]==result[index3]*3) index3++;
            if(result[begin]==result[index5]*5) index5++;
            begin++;
        }
        return result[--begin];

    }


    public static void main(String[] args) {
        int i = new Solution().nthUglyNumber(1600);
        System.out.println(i);

    }

}
