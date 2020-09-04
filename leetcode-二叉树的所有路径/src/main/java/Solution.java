import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author uhyils <247452312@qq.com>
 * @date 文件创建日期 2020年09月04日 16时33分
 */
public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> treeStr = getTreeStr(root, "");
        return treeStr.stream().map(treestring -> treestring.substring(0, treestring.length() - 2)).collect(Collectors.toList());
    }

    private List<String> getTreeStr(TreeNode root, String parentStr) {
        if (root == null) {
            return null;
        }
        parentStr += root.val + "->";
        List<String> leftStr = getTreeStr(root.left, parentStr);

        List<String> rightStr = getTreeStr(root.right, parentStr);

        if (rightStr == null && leftStr == null) {
            List<String> result = new ArrayList<>();
            result.add(parentStr);
            return result;
        }
        if (leftStr == null && rightStr != null) {
            return rightStr;
        }
        if (leftStr != null && rightStr == null) {
            return leftStr;
        }
        leftStr.addAll(rightStr);
        return leftStr;
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;

        List<String> strings = new Solution().binaryTreePaths(treeNode1);
        for (String string : strings) {
            System.out.println(string);
        }

    }
}
