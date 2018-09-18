import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * <p>
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-29 17:25
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();

        count(root, list, k);

        Integer integer = list.get(k - 1);
        return integer;
    }

    private void count(TreeNode root, List<Integer> list, int k) {
        if (list.size() >= k) {
            return;
        }
        if (root == null) {
            return;
        }
        if (root.left != null) {
            count(root.left, list, k);
        }
        list.add(root.val);
        if (root.right != null) {
            count(root.right, list, k);
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.right = new TreeNode(1);
        treeNode.left = new TreeNode(-1);
        int i = new Solution().kthSmallest(treeNode, 3);
        System.out.println(i);
    }
}
