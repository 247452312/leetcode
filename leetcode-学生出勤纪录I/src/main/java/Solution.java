/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-07-25 13:09
 */
public class Solution {

    private static final char ABSENT = 'A';
    private static final char LATE = 'L';
    private static final char PRESENT = 'P';


    public boolean checkRecord(String s) {
        Boolean a = false;
        Boolean ll = false;
        char last = PRESENT;
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            switch (t) {
                case ABSENT:
                    if (a) {
                        return false;
                    }
                    a = true;
                    ll = false;
                    break;
                case LATE:
                    if(ll){
                        return false;
                    }
                    if(last == LATE){
                        ll = true;
                    }
                    break;
                case PRESENT:
                    ll = false;
                    break;
                default:
                    return false;
            }
            last = t;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.checkRecord("PPALLL");
        System.out.println(b);
    }

}
