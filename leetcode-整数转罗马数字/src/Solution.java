/**
 * @author uhyils <247452312@qq.com>
 * @date 文件创建日期 2020年05月14日 15时11分
 */
public class Solution {
    public String intToRoman(int num) {
        int qm = num / 1000; // 千
        int i = num % 1000;
        int bl = i / 100; // 百
        i = i % 100;
        int ui = i / 10; // 十
        int ge = i % 10; // 个

        StringBuilder sb = new StringBuilder();

        getQm(qm, sb);

        getBl(bl, sb);

        getUi(ui, sb);

        getGe(ge, sb);
        return sb.toString();

    }

    private final void getGe(int ge, StringBuilder sb) {
        if (ge == 4) {
            sb.append("IV");
        } else {
            if (ge >= 5) {
                if (ge == 9) {
                    sb.append("IX");
                    return;
                }
                sb.append("V");
                for (int j = 5; j < ge; j++) {
                    sb.append("I");
                }
            } else {
                for (int j = 0; j < ge; j++) {
                    sb.append("I");
                }
            }
        }
    }

    private final void getUi(int ui, StringBuilder sb) {
        if (ui == 4) {
            sb.append("XL");
        } else {
            if (ui >= 5) {
                if (ui == 9) {
                    sb.append("XC");
                    return;
                }
                sb.append("L");
                for (int j = 5; j < ui; j++) {
                    sb.append("X");
                }
            } else {
                for (int j = 0; j < ui; j++) {
                    sb.append("X");
                }
            }
        }
    }

    private final void getBl(int bl, StringBuilder sb) {
        if (bl == 4) {
            sb.append("CD");
        } else {
            if (bl >= 5) {
                if (bl == 9) {
                    sb.append("CM");
                    return;
                }
                sb.append("D");
                for (int j = 5; j < bl; j++) {
                    sb.append("C");
                }
            } else {
                for (int j = 0; j < bl; j++) {
                    sb.append("C");
                }
            }
        }
    }

    private final void getQm(int qm, StringBuilder sb) {
        for (int i = 0; i < qm; i++) {
            sb.append("M");
        }
    }


    public static void main(String[] args) {
        String s = new Solution().intToRoman(40);
        System.out.println(s);
    }
}
