import java.util.HashMap;

/**
 * //给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * //
 * // 说明：每次只能向下或者向右移动一步。
 * //
 * // 示例:
 * //
 * // 输入:
 * //[
 * //  [1,3,1],
 * //  [1,5,1],
 * //  [4,2,1]
 * //]
 * //输出: 7
 * //解释: 因为路径 1→3→1→1→1 的总和最小。
 * //
 * // Related Topics 数组 动态规划
 * // 👍 621 👎 0
 *
 * @author uhyils <247452312@qq.com>
 * @date 文件创建日期 2020年08月13日 09时01分
 */
public class Solution {

    public static HashMap<Integer, Integer> map;

    public int minPathSum(int[][] grid) {
        map = new HashMap<>(grid.length * grid[0].length);
        return getMinPathSum(grid, 0, 0);
    }

    private int getMinPathSum(int[][] grid, int i, int j) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        if (i >= grid.length || j >= grid[0].length) {
            return -1;
        }

        int minPathSumLeft;
        int keyLeft = grid[0].length * i + j + 1;
        if (map.containsKey(keyLeft)) {
            minPathSumLeft = map.get(keyLeft);
        } else {
            minPathSumLeft = getMinPathSum(grid, i, j + 1);
        }
        if (minPathSumLeft >= 0) {
            map.put(keyLeft, minPathSumLeft);
        }
        int minPathSumBut;
        int keyBut = grid[0].length * (i + 1) + j;
        if (map.containsKey(keyBut)) {
            minPathSumBut = map.get(keyBut);
        } else {
            minPathSumBut = getMinPathSum(grid, i + 1, j);
        }
        if (minPathSumBut >= 0) {
            map.put(keyBut, minPathSumBut);
        }
        if (minPathSumBut < 0) {
            minPathSumBut = minPathSumLeft;
        }
        if (minPathSumLeft < 0) {
            minPathSumLeft = minPathSumBut;
        }

        return grid[i][j] + Math.min(minPathSumLeft, minPathSumBut);
    }

    public static void main(String[] args) {
        int i = new Solution().minPathSum(new int[][]{{1, 2}, {1, 1}});
        System.out.println(i);
    }
}
