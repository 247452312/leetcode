import java.util.Arrays;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * <p>
 * <p>
 * <p>
 * Note:
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 *
 * @author uhyils <247452312@qq.com>
 * @date 文件创建日期 2020年03月26日 09时12分
 */
public class Solution {

    public static String recursionList = "";

    public void solveSudoku(char[][] board) {
        int[][][] mark = new int[9][9][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    mark[i][j][0] = 1;
                    for (char c : board[i]) {
                        if (c != '.') {
                            mark[i][j][c - '0'] = 1;
                        }
                    }
                    for (char[] chars : board) {
                        if (chars[j] != '.') {
                            mark[i][j][chars[j] - '0'] = 1;
                        }
                    }

                    for (int k = i / 3 * 3; k < i / 3 * 3 + 3; k++) {
                        for (int l = j / 3 * 3; l < j / 3 * 3 + 3; l++) {
                            if (board[k][l] != '.') {
                                mark[i][j][board[k][l] - '0'] = 1;
                            }
                        }
                    }
                } else {
                    for (int k = 1; k < 10; k++) {
                        mark[i][j][k] = 1;

                    }
                    mark[i][j][board[i][j] - '0'] = 0;
                }
            }
        }
        recursionList += "->testFull";
        System.out.println(recursionList);
        testFull(board, mark);
    }


    private void testFull(char[][] chars, int[][][] marks) {

        char[][] board = new char[chars.length][chars[0].length];
        int[][][] mark = new int[marks.length][marks[0].length][marks[0][0].length];

        for (int i1 = 0; i1 < chars.length; i1++) {
            for (int i2 = 0; i2 < chars[i1].length; i2++) {
                board[i1][i2] = chars[i1][i2];
            }
        }
        for (int i1 = 0; i1 < marks.length; i1++) {
            for (int i2 = 0; i2 < marks[i1].length; i2++) {
                for (int i3 = 0; i3 < marks[i1][i2].length; i3++) {
                    mark[i1][i2][i3] = marks[i1][i2][i3];
                }
            }
        }


        while (isFull(mark) == false && isCanFull(mark)) {
            boolean thi_full = false;
            boolean all_full = false;
            for (int i = 0; i < mark.length; i++) {
                for (int j = 0; j < mark[i].length; j++) {
                    if (mark[i][j][0] == 0) {
                        continue;
                    }

                    int blankCell = 0;
                    int result = 0;
                    //看这里只能填那一个数字,就填哪一个数字
                    for (int k = 1; k < mark[i][j].length; k++) {
                        if (mark[i][j][k] == 0) {
                            blankCell++;
                            result = k;
                        }
                    }
                    if (blankCell == 1) {
                        thi_full = true;
                        all_full = true;
                        board[i][j] = (char) (result + '0');
                        mark[i][j][0] = 0;
                        fullNewAddNum(mark, i, j, result);
                    }
                }
            }
            //如果一整遍都没有填写
            if (thi_full == false) {
                for (int i = 0; i < mark.length; i++) {
                    for (int j = 0; j < mark[i].length; j++) {
                        //反推
                        for (int i1 = 1; i1 < mark[i][j].length; i1++) {
                            if (mark[i][j][0] == 0) {
                                continue;
                            }
                            boolean canFull = true;
                            for (int k = i / 3 * 3; k < i / 3 * 3 + 3; k++) {
                                for (int l = j / 3 * 3; l < j / 3 * 3 + 3; l++) {
                                    if (k == i && l == j) {
                                        continue;
                                    }
                                    if (mark[k][l][i1] == 0) {
                                        canFull = false;
                                    }
                                }
                            }
                            if (canFull == true) {
                                all_full = true;
                                board[i][j] = (char) (i1 + '0');
                                mark[i][j][0] = 0;
                                fullNewAddNum(mark, i, j, i1);
                                break;
                            }

                        }
                    }
                }
            }

            //如果反推以及正推都不能推出结果
            if (thi_full == false && all_full == false) {
                //尝试回溯算法
                recursionList += "->backFull";
                System.out.println(recursionList);
                backFull(board, mark);
                recursionList = recursionList.substring(0, recursionList.length() - 10);
                System.out.println(recursionList);

                if (isFull(mark)) {
                    for (int i1 = 0; i1 < chars.length; i1++) {
                        for (int i2 = 0; i2 < chars[i1].length; i2++) {
                            chars[i1][i2] = board[i1][i2];
                        }
                    }
                    for (int i1 = 0; i1 < marks.length; i1++) {
                        for (int i2 = 0; i2 < marks[i1].length; i2++) {
                            for (int i3 = 0; i3 < marks[i1][i2].length; i3++) {
                                marks[i1][i2][i3] = mark[i1][i2][i3];
                            }
                        }
                    }
                    return;
                }
            }
        }


    }

    /**
     * 判断这个数独能不能填写
     *
     * @param mark
     * @return
     */
    private boolean isCanFull(int[][][] mark) {
        for (int[][] ints : mark) {
            for (int[] anInt : ints) {
                //这一个格子能不能填
                boolean canFull = false;
                for (int i = 0; i < anInt.length; i++) {
                    if (anInt[i] == 0) {
                        canFull = true;
                    }
                }
                if (canFull == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private void backFull(char[][] chars, int[][][] marks) {
        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < marks[i].length; j++) {
                if (marks[i][j][0] == 0) {
                    continue;
                }
                //每一个格子能填的所有数字
                for (int k = 1; k < marks[i][j].length; k++) {
                    //这个格子没填而且能填k值
                    if (marks[i][j][k] == 0) {
                        char[][] board = new char[chars.length][chars[0].length];
                        int[][][] mark = new int[marks.length][marks[0].length][marks[0][0].length];

                        for (int i1 = 0; i1 < chars.length; i1++) {
                            for (int i2 = 0; i2 < chars[i1].length; i2++) {
                                board[i1][i2] = chars[i1][i2];
                            }
                        }
                        for (int i1 = 0; i1 < marks.length; i1++) {
                            for (int i2 = 0; i2 < marks[i1].length; i2++) {
                                for (int i3 = 0; i3 < marks[i1][i2].length; i3++) {
                                    mark[i1][i2][i3] = marks[i1][i2][i3];
                                }
                            }
                        }

                        board[i][j] = (char) (k + '0');
                        mark[i][j][0] = 0;
                        fullNewAddNum(mark, i, j, k);

                        System.out.println("第" + (i + 1) + "行,第" + (j + 1) + "列,回溯法插入值为:" + k);
                        recursionList += "->testFull";
                        System.out.println(recursionList);
                        testFull(board, mark);
                        recursionList = recursionList.substring(0, recursionList.length() - 10);
                        System.out.println(recursionList);

                        if (isFull(mark)) {
                            for (int i1 = 0; i1 < chars.length; i1++) {
                                for (int i2 = 0; i2 < chars[i1].length; i2++) {
                                    chars[i1][i2] = board[i1][i2];
                                }
                            }
                            for (int i1 = 0; i1 < marks.length; i1++) {
                                for (int i2 = 0; i2 < marks[i1].length; i2++) {
                                    for (int i3 = 0; i3 < marks[i1][i2].length; i3++) {
                                        marks[i1][i2][i3] = mark[i1][i2][i3];
                                    }
                                }
                            }
                            return;
                        }
                    }
                }
                return;
            }
        }


    }


    /**
     * 将填充数字所在行,列,大格子 的mark填充数字
     *
     * @param mark
     * @param i
     * @param j
     * @param result
     */
    private void fullNewAddNum(int[][][] mark, int i, int j, int result) {
        //行
        for (int k = 0; k < 9; k++) {
            mark[i][k][result] = 1;
        }
        //列
        for (int k = 0; k < 9; k++) {
            mark[k][j][result] = 1;
        }
        //大格子
        for (int k = i / 3 * 3; k < i / 3 * 3 + 3; k++) {
            for (int l = j / 3 * 3; l < j / 3 * 3 + 3; l++) {
                mark[k][l][result] = 1;
            }
        }

        //自己
        for (int i1 = 1; i1 < mark[i][j].length; i1++) {
            if (i1 == result) {
                mark[i][j][i1] = 0;
            } else {
                mark[i][j][i1] = 1;
            }
        }


    }

    /**
     * 判断是否填充完成
     *
     * @param mark
     * @return
     */
    private boolean isFull(int[][][] mark) {
        for (int[][] ints : mark) {
            for (int[] anInt : ints) {
                if (anInt[0] == 1) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] chars = {{'.', '.', '9', '7', '4', '8', '.', '.', '.'}, {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '2', '.', '1', '.', '9', '.', '.', '.'}, {'.', '.', '7', '.', '.', '.', '2', '4', '.'}, {'.', '6', '4', '.', '1', '.', '5', '9', '.'}, {'.', '9', '8', '.', '.', '.', '3', '.', '.'}, {'.', '.', '.', '8', '.', '3', '.', '2', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '6'}, {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};

        long start = System.currentTimeMillis();
        new Solution().solveSudoku(chars);
        long end = System.currentTimeMillis();

        System.out.println("使用了" + (end - start) + "ms");

        for (char[] aChar : chars) {
            for (int i = 0; i < aChar.length; i++) {
                System.out.print(aChar[i] + ",");
            }
            System.out.println();
        }


    }
}
