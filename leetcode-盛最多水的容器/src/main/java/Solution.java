/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * <p>
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * @author uhyils <247452312@qq.com>
 * @date 文件创建日期 2019年02月01日 12时59分
 */
public class Solution {
    public int maxArea(int[] height) {
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }
        int max = 0;
        int i = 0;
        int j = height.length - 1;
        while (j > i) {
            int h = Math.min(height[i], height[j]);
            max = Math.max(max, h * (j - i));
            if (height[i] > height[j]) {
                int temp = j;
                while (j > i && height[--j] <= height[temp]) ;
            } else {
                int temp = i;
                while (j > i && height[++i] <= height[temp]) ;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int i = new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);
    }
}
