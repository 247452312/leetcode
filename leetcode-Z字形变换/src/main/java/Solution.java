/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * @author uhyils <247452312@qq.com>
 * @date 文件创建日期 2019年02月01日 10时02分
 */
public class Solution {

    public String convert(String s, int numRows) {
        if (s == null) {
            return null;
        }
        if (numRows >= s.length() || s.length() == 0 || numRows ==1) {
            return s;
        }
        char[] sChar = s.toCharArray();
        int length = s.length();
        int a = length % (2 * numRows - 2);
        int b = length / (2 * numRows - 2);
        int colNum;
        if (a == 0) {
            colNum = (numRows - 1) * b;
        } else if (a <= numRows) {
            colNum = (numRows - 1) * b + 1;
        } else {
            colNum = (numRows - 1) * b + a - numRows + 1;
        }
        char[][] chss = new char[numRows][colNum];

        int x = -1;
        int y = 0;
        int num = 0;
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < numRows; j++) {
                chss[++x][y] = sChar[num];
                num++;
            }
            for (int j = 0; j < numRows - 2; j++) {
                chss[--x][++y] = sChar[num];
                num++;
            }
            x = -1;
            y++;
        }
        if (a == 0) {
        } else if (a <= numRows) {
            for (int i = num; i < length; i++) {
                chss[++x][y] =sChar[i];
            }
        } else if (a > numRows) {
            for (int i = 0; i < numRows; i++) {
                chss[++x][y] = sChar[num];
                num++;
            }
            for (int i = num; i < length; i++) {
                chss[--x][++y] = sChar[i];
            }
        }
        StringBuilder sb = new StringBuilder();

        for (char[] chars : chss) {
            for (char aChar : chars) {
                if (aChar == '\u0000') {
                    continue;
                }
                sb.append(aChar);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String convert = solution.convert("AB", 1);
        System.out.println(convert);
    }
}
