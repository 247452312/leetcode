import java.util.ArrayList;
import java.util.List;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * <p>
 * 上图是一个部分填充的有效的数独。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-27 16:26
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        for (char[] chars : board) {
            if (check(chars) == false) {
                return false;
            }
        }
        reverse(board);
        for (char[] chars : board) {
            if (check(chars) == false) {
                return false;
            }
        }

        int[] m = new int[]{0, 3, 6, 9};
        for (int i = 0; i < m.length - 1; i++) {
            for (int k = 0; k < m.length - 1; k++) {

                char[] ch = new char[9];
                int mm = 0;
                for (int s1 = m[i]; s1 < m[i + 1]; s1++) {
                    for (int s2 = m[k]; s2 < m[k + 1]; s2++) {
                        ch[mm] = board[s1][s2];
                        mm++;
                    }
                }
                if (check(ch) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean check(char[] chars) {
        int[] make = new int[9];
        for (char aChar : chars) {
            if (aChar == '.') {
                continue;
            }
            if (make[aChar - 49] == 1) {
                return false;
            }
            make[aChar - 49] = 1;
        }
        return true;
    }

    // 将矩阵转置
    public void reverse(char temp[][]) {
        for (int i = 0; i < temp.length; i++) {
            for (int j = i; j < temp[i].length; j++) {
                char k = temp[i][j];
                temp[i][j] = temp[j][i];
                temp[j][i] = k;
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] chars = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean validSudoku = solution.isValidSudoku(chars);
        System.out.println(validSudoku);

    }


    public boolean batter(char[][] board) {
        int[][] signs = new int[3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int n = 1 << (board[i][j] - '1');
                int cubeIndex = i / 3 * 3 + j / 3;
                if ((signs[0][i] & n) != 0 || (signs[1][j] & n) != 0 || (signs[2][cubeIndex] & n) != 0) {
                    return false;
                }
                signs[0][i] |= n;
                signs[1][j] |= n;
                signs[2][cubeIndex] |= n;
            }
        }
        return true;
    }

}
