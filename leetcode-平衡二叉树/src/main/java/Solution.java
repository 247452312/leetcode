/**
 * @author uhyils <247452312@qq.com>
 * @date 文件创建日期 2020年08月17日 07时50分
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        Integer balance = isBalance(root);
        if (balance == null) {
            return false;
        } else {
            return true;
        }
    }

    public Integer isBalance(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Integer left = isBalance(root.left);
        Integer right = isBalance(root.right);
        if (left == null || right == null) {
            return null;
        }
        if (Math.abs(left - right) > 1) {
            return null;
        }
        return Math.max(left, right) + 1;
    }
}
