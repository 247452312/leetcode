/**
 * 虚拟 用户通过次数 0
 * 虚拟 用户尝试次数 0
 * 虚拟 通过次数 0
 * 虚拟 提交次数 0
 * 题目难度 Easy
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 * <p>
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * <p>
 * 给出两个矩形，判断它们是否重叠并返回结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出：false
 * 说明：
 * <p>
 * 两个矩形 rec1 和 rec2 都以含有四个整数的列表的形式给出。
 * 矩形中的所有坐标都处于 -10^9 和 10^9 之间。
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-30 12:55
 */
public class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];

        int a1 = rec2[0];
        int b1 = rec2[1];
        int a2 = rec2[2];
        int b2 = rec2[3];


        if (a1 > x1 - (a2 - a1) && a1 < x2 && b1 < y2 && b1 > y1 - (b2 - b1)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean rectangleOverlap = new Solution().isRectangleOverlap(new int[]{1, 2, 3}, new int[]{3, 2, 1});
        System.out.println(rectangleOverlap);
    }
}
