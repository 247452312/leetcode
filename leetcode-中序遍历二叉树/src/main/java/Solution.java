import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-29 16:02
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        get(root, list);
        return list;
    }

    private void get(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        get(root.left, list);
        list.add(root.val);
        get(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.right = new TreeNode(1);
        treeNode.left = new TreeNode(-1);
        List<Integer> list = new Solution().inorderTraversal(treeNode);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }



    public List<Integer> batter(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.addFirst(root);
                root = root.left;
            }
            root = stack.removeFirst();
            list.add(root.val);
            root = root.right;
        }

        return list;

    }
}
