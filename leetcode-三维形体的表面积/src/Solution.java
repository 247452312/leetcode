/**
 * @author uhyils <247452312@qq.com>
 * @date 文件创建日期 2020年03月25日 14时10分
 */
public class Solution {
    public int surfaceArea(int[][] grid) {
        int b = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int one_grid = grid[i][j];
                if (one_grid == 0) {
                    continue;
                }
                b = b + 2 + 4 * one_grid;
                //上
                if (i != 0) {
                    b = b - 2 * Math.min(one_grid, grid[i - 1][j]);
                }
                //左
                if (j != 0) {
                    b = b - 2 * Math.min(one_grid, grid[i][j - 1]);
                }
            }
        }
        return b;
    }


    public static void main(String[] args) {
        int i = new Solution().surfaceArea(new int[][]{{1, 2}, {3, 4}});
        System.out.println(i);
    }
}