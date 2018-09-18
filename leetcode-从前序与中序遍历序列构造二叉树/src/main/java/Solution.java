import java.util.Arrays;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-29 16:46
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int i = 0;
        for (; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                break;
            }
        }
        //此时i为节点
        root.left = buildTree(
                Arrays.copyOfRange(preorder, 1, i + 1),
                Arrays.copyOfRange(inorder, 0, i)
        );
        root.right = buildTree(
                Arrays.copyOfRange(preorder, i + 1, preorder.length),
                Arrays.copyOfRange(inorder, i + 1, inorder.length)
        );
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new Solution().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

        int i = 1;
    }


    public TreeNode batter(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        TreeNode root = helper(preorder, inorder, 0, 0, inorder.length - 1);
        return root;
    }

    private TreeNode helper(int[] preorder, int[] inorder, int pl, int il, int ir) {
        int val = preorder[pl];
        TreeNode node = new TreeNode(val);
        int iRoot = ir;
        while (iRoot > il) {
            if (val == inorder[iRoot]) {
                break;
            }
            iRoot--;
        }

        if (iRoot > il) {
            node.left = helper(preorder, inorder, pl + 1, il, iRoot - 1);
        }

        if (iRoot < ir) {
            node.right = helper(preorder, inorder, pl + 1 + (iRoot - il), iRoot + 1, ir);
        }
        return node;
    }
}
