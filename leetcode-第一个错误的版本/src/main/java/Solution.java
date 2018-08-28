/**
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * <p>
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * <p>
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * <p>
 * 示例:
 * <p>
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 * <p>
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 * <p>
 * 所以，4 是第一个错误的版本。
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-28 12:54
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return geterrorVersion(0, n);
    }

    private int geterrorVersion(int start, int end) {
        if (end == start) {
            return start;
        }
        if (end - start == 1) {
            return end;
        }
        int ifbad = start + (end - start) / 2;
        if (isBadVersion(ifbad)) {
            return geterrorVersion(start, ifbad);
        } else {
            return geterrorVersion(ifbad, end);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 12;
        int i = solution.firstBadVersion(n);
        System.out.println(i);
    }
}
