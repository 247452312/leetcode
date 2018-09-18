import java.util.Arrays;

/**
 * 一行中有 N 张多米诺骨牌，我们将每张多米诺骨牌垂直竖立。
 * <p>
 * 在开始时，我们同时把一些多米诺骨牌向左或向右推。
 * <p>
 * <p>
 * <p>
 * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。
 * <p>
 * 同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
 * <p>
 * 如果同时有多米诺骨牌落在一张垂直竖立的多米诺骨牌的两边，由于受力平衡， 该骨牌仍然保持不变。
 * <p>
 * 就这个问题而言，我们会认为正在下降的多米诺骨牌不会对其它正在下降或已经下降的多米诺骨牌施加额外的力。
 * <p>
 * 给定表示初始状态的字符串 "S" 。如果第 i 张多米诺骨牌被推向左边，则 S[i] = 'L'；如果第 i 张多米诺骨牌被推向右边，则 S[i] = 'R'；如果第 i 张多米诺骨牌没有被推动，则 S[i] = '.'。
 * <p>
 * 返回表示最终状态的字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：".L.R...LR..L.."
 * 输出："LL.RR.LLRRLL.."
 * 示例 2：
 * <p>
 * 输入："RR.L"
 * 输出："RR.L"
 * 说明：第一张多米诺骨牌没有给第二张施加额外的力。
 * 提示：
 * <p>
 * 0 <= N <= 10^5
 * 表示多米诺骨牌状态的字符串只含有 'L'，'R'; 以及 '.';
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-30 13:10
 */
public class Solution {
    public String pushDominoes(String dominoes) {
        char[] chars = dominoes.toCharArray();
        int[] ints = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.') {
                continue;
            } else if (chars[i] == 'R') {
                ints[i] = 2;
            } else if (chars[i] == 'L') {
                ints[i] = 1;
            }
        }
        while (true) {
            char[] last = Arrays.copyOf(chars, chars.length);
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '.') {
                    continue;
                } else if (chars[i] == 'R') {
                    if (i == chars.length - 1) {
                        ints[i] = 2;
                        continue;
                    } else {
                        if (ints[i + 1] == 0) {
                            ints[i + 1] = 2;
                        } else if (ints[i + 1] == 1) {
                            continue;
                        } else if (ints[i + 1] == 2) {
                            continue;
                        }
                    }
                } else if (chars[i] == 'L') {
                    if (i == 0) {
                        continue;
                    } else {
                        if (ints[i - 1] == 0) {
                            ints[i - 1] = 1;
                        } else if (ints[i - 1] == 1) {
                            continue;
                        } else if (ints[i - 1] == 2) {
                            if (chars[i - 1] == '.') {
                                ints[i - 1] = 0;
                            }
                            continue;
                        }
                    }
                }
            }

            for (int i = 0; i < chars.length; i++) {
                if (ints[i] == 0) {
                    continue;
                } else if (ints[i] == 1) {
                    chars[i] = 'L';
                } else if (ints[i] == 2) {
                    chars[i] = 'R';
                }
            }
            if (new String(chars).equals(new String(last))) {
                break;
            }
        }
        return new String(chars);
    }





    public static void main(String[] args) {
        String s = new Solution().pushDominoes("L.....RR.RL.....L.R.");
        System.out.println(s);
    }



    public String batter(String dominoes) {

        if(dominoes == null || dominoes.isEmpty()){
            return dominoes;
        }

        char ca[] = dominoes.toCharArray();

        boolean hasR = false;
        int midCount = 0;
        for(int i = 0; i < ca.length; ++i){
            if(ca[i] == 'R'){
                if(hasR == true){
                    for(int j = 0; j < midCount; ++j){
                        ca[i - midCount + j] = 'R';
                    }
                }
                midCount = 0;
                hasR = true;
            }else if(ca[i] == 'L'){
                if(hasR == true && midCount > 0){
                    for(int j = 0; j < midCount/2; ++j){
                        ca[i - 1 - j] = 'L';
                        ca[i - midCount + j] = 'R';
                    }
                }else{
                    for(int j = 0; j < midCount; ++j){
                        ca[i - midCount + j] = 'L';
                    }
                }
                hasR = false;
                midCount = 0;
            }else{
                ++midCount;
            }
        }

        if(hasR == true && midCount > 0){
            for(int j = 0; j < midCount; ++j){
                ca[ca.length - midCount + j] = 'R';
            }
        }

        return new String(ca);
    }
}
