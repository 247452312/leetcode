/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-28 12:58
 */
public class VersionControl {
    boolean isBadVersion(int version) {
        if (version < 4) {
            return false;
        }
        return true;
    }
}
