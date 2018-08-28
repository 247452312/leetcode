import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-28 10:45
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        List<TreeNode> treeList = new ArrayList<>();
        treeList.add(root);
        while (true) {
            List<Integer> li = getList(treeList);
            if (li == null || li.size() == 0) {
                break;
            }
            lists.add(li);
        }
        return lists;

    }

    private List<Integer> getList(List<TreeNode> treeList) {
        List<Integer> list = new ArrayList<>();
        List<TreeNode> tree = new ArrayList<>();
        for (TreeNode treeNode : treeList) {
            list.add(treeNode.val);
            if (treeNode.left != null) {
                tree.add(treeNode.left);
            }
            if (treeNode.right != null) {
                tree.add(treeNode.right);
            }
        }
        treeList.clear();
        treeList.addAll(tree);
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.left = new TreeNode(3);
        treeNode.left.left = new TreeNode(2);
        List<List<Integer>> lists = solution.levelOrder(treeNode);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.printf(" " + integer);
            }
            System.out.println();
        }
    }




    public List<List<Integer>> batter(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        set(root, 0, result);
        return result;
    }

    public void set(TreeNode treeNode, int level, List<List<Integer>> result) {
        if(treeNode==null){
            return;
        }
        if(level==result.size()){
            result.add(new ArrayList<>());
        }
        result.get(level).add(treeNode.val);
        set(treeNode.left,level+1,result);
        set(treeNode.right,level+1,result);
    }


}
