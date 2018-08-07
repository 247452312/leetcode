/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-07-25 09:34
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int startRow = 0;
        int endRow = matrix.length;
        if (target < matrix[0][0] || target > matrix[endRow - 1][matrix[endRow - 1].length - 1]) {
            return false;
        }

        while (true) {
            int i = (endRow - startRow) / 2;

            if (matrix[startRow + i][0] == target) {
                return true;
            } else if (matrix[startRow + i][0] > target) {
                endRow = startRow + i;
            } else {
                startRow += i;
            }
            if (endRow - startRow == 1) {
                break;
            }
            if (i == 0) {
                return false;
            }

        }
        int[] m = matrix[startRow];
        int end = m.length;
        int start = 0;
        while (true) {
            int i = (end - start) / 2;
            if (m[start + i] == target) {
                return true;
            } else if (m[start + i] > target) {
                end = start + i;
            } else {
                start += i;
            }
            if (end - start == 1) {
                if (m[start] == target) {
                    return true;
                }
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] i = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        Solution solution = new Solution();
        boolean b = solution.searchMatrix(i, 1);
        System.out.println(b);

    }
}
