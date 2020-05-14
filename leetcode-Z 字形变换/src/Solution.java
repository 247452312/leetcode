/**
 * @author uhyils <247452312@qq.com>
 * @date 文件创建日期 2020年04月30日 14时43分
 */
public class Solution {

    public String convert(String s, int numRows) {
        if (numRows == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder[] sb = new StringBuilder[numRows];
        int num = 0;
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        int again = numRows * 2 - 2;
        int index = 0;
        for (int i = 0; i < chars.length; i += again) {

            int k = i % again; // 循环中index
            for (int j = 0; j < numRows; j++) {
                if (index >= chars.length) {
                    break;
                }
                sb[num].append(chars[index]);
                index++;
                num++;
            }
            num--;
            for (int kk = 0; kk < numRows - 2; kk++) {
                if (index >= chars.length) {
                    break;
                }
                num--;
                sb[num].append(chars[index]);
                index++;
            }
            num--;

        }


        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();

    }

    public static void main(String[] args) {
        String convert = new Solution().convert("LEETCODEISHIRING", 3);

        System.out.println(convert);
    }
}
