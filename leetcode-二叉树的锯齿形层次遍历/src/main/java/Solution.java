import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-29 16:10
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<TreeNode>> treeLists = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        int deep = 0;
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);

        boolean b = false;
        for (TreeNode treeNode : treeNodes) {
            if (treeNode.left != null || treeNode.right != null) {
                b = true;
            }
        }
        treeLists.add(treeNodes);

        while (b) {
            deep++;
            List<TreeNode> treeNodes1 = new ArrayList<>();
            if (deep % 2 == 1) {
                //从右到左
                for (int i = treeNodes.size()-1 ; i>=0; i--) {
                    TreeNode treeNode = treeNodes.get(i);
                    if (treeNode.right != null) {
                        treeNodes1.add(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        treeNodes1.add(treeNode.left);
                    }
                }
            } else {
                //从左到右
                for (int i = treeNodes.size()-1 ; i>=0; i--) {
                    TreeNode treeNode = treeNodes.get(i);
                    if (treeNode.left != null) {
                        treeNodes1.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        treeNodes1.add(treeNode.right);
                    }
                }
            }
            b = false;
            for (TreeNode treeNode : treeNodes1) {
                if (treeNode.left != null || treeNode.right != null) {
                    b = true;
                }
            }
            treeLists.add(treeNodes1);
            treeNodes = treeNodes1;
        }

        for (List<TreeNode> treeList : treeLists) {
            List<Integer> ints = new ArrayList<>();
            for (TreeNode treeNode : treeList) {
                ints.add(treeNode.val);
            }
            lists.add(ints);
        }

        return lists;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        List<List<Integer>> lists = solution.zigzagLevelOrder(treeNode);

        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.printf(" " + integer);
            }
            System.out.println();
        }

    }
}
