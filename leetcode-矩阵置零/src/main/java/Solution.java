import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 * 进阶:
 * <p>
 * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个常数空间的解决方案吗？
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-29 11:43
 */
public class Solution {
    class Tow {
        int a;
        int b;

        public Tow(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public void setZeroes(int[][] matrix) {
        List<Tow> tows = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    Tow tow = new Tow(i,j);
                    tows.add(tow);
                }
            }
        }
        for (Tow tow : tows) {
            for (int k = 0; k < matrix.length; k++) {
                matrix[k][tow.b] = 0;
            }
            for (int k = 0; k < matrix[0].length; k++) {
                matrix[tow.a][k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] in = new int[][]{{0, 1, 2, 0}, {1, 4, 5, 2}, {1, 3, 1, 5}};
        solution.setZeroes(in);

        for (int[] ints : in) {
            for (int anInt : ints) {
                System.out.printf(" " + anInt);
            }
            System.out.println();
        }

    }

}
