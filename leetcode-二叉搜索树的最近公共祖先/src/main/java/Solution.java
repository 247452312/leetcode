/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-07-25 13:27
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        String[] string = getString(root, p.val, q.val);

        int i = 0;
        for (int j = 0; j <= Math.min(string[0].length(), string[1].length()); j++) {
            i = j;
            if (j >= string[0].length() || j >= string[1].length() || string[0].charAt(j) != string[1].charAt(j)) {
                break;
            }
        }
        TreeNode res = root;
        String right = string[0].substring(0, i);
        for (int j = 0; j < right.length(); j++) {
            char c = right.charAt(j);
            if (c == '0') {
                res = res.left;
            } else {
                res = res.right;
            }
        }
        return res;
    }

    private String[] getString(TreeNode treeNode, int p, int q) {
        String[] s = new String[2];
        s[0] = cheak(treeNode, p, "");
        s[1] = cheak(treeNode, q, "");
        return s;
    }

    private String cheak(TreeNode treeNode, int p, String s) {
        if (treeNode == null ) {
            return null;
        }
        int val = treeNode.val;
        if (val == p) {
            return s;
        }
        String left = cheak(treeNode.left, p, s);
        if (left != null) {
            return s + "0" + left;
        }
        String right = cheak(treeNode.right, p, s);
        if (right != null) {
            return s + "1" + right;
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode[] treeNodes = new TreeNode[5];
        for (int i = 0; i < treeNodes.length; i++) {
            treeNodes[i] = new TreeNode(i);
        }
//        treeNodes[6].left = treeNodes[2];
//        treeNodes[6].right = treeNodes[8];
//        treeNodes[2].left = treeNodes[0];
//        treeNodes[2].right = treeNodes[4];
//        treeNodes[4].left = treeNodes[3];
//        treeNodes[4].right = treeNodes[5];
//        treeNodes[8].left = treeNodes[7];
//        treeNodes[8].right = treeNodes[9];

//        treeNodes[2].right = treeNodes[3];
        treeNodes[3].left = treeNodes[1];
        treeNodes[3].right = treeNodes[4];
        treeNodes[1].right = treeNodes[2];

        TreeNode treeNode = solution.lowestCommonAncestor(treeNodes[3], treeNodes[2], treeNodes[4]);
        System.out.println(treeNode.val);


    }

}
