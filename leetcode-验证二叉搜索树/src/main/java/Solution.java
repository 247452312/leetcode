import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-28 10:45
 */
public class Solution {

    class Link {
        int val;
        Link next;

        public Link(int val) {
            this.val = val;
        }
    }

    public boolean isValidBST(TreeNode root) {
        Link s = getString(root);
        while (s != null && s.next != null) {
            if (s.val >= s.next.val) {
                return false;
            }
            s = s.next;
        }
        return true;
    }

    public Link getString(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return new Link(root.val);
        }
        Link link1 = getString(root.left);
        Link link2 = new Link(root.val);
        Link link3 = getString(root.right);
        Link link = new Link(0);
        Link temp = link;
        if (link1 != null) {
            temp.next = link1;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        if (link2 != null) {
            temp.next = link2;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        if (link3 != null) {
            temp.next = link3;
        }

        return link.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        boolean i = solution.isValidBST(treeNode);
        System.out.println(i);
    }




    private TreeNode pre;
    public boolean batter(TreeNode root) {
        if(root==null){
            return true;
        }
        boolean f = batter(root.left);
        boolean f2 = pre==null||pre.val<root.val;
        pre = root;
        return f&&f2&&batter(root.right);


    }
}
