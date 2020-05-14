/**
 * @author uhyils <247452312@qq.com>
 * @date 文件创建日期 2020年05月11日 11时00分
 */
public class Solution {
    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    public static void main(String[] args) {
        double v = new Solution().myPow(3, 44);
        System.out.println(v);
    }
}
