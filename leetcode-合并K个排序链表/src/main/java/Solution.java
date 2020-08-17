/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * @author uhyils <247452312@qq.com>
 * @date 文件创建日期 2019年02月01日 16时04分
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = new ListNode(0);
        ListNode position = listNode;
        int min = Integer.MAX_VALUE;
        int index = -1;
        while (!allNo(lists)) {
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && min >= lists[i].val) {
                    min = lists[i].val;
                    index = i;
                }
            }
            if (index == -1) {
                break;
            }
            position.next = lists[index];
            position = position.next;
            lists[index] = lists[index].next;
            min = Integer.MAX_VALUE;
            index = -1;
        }

        return listNode.next;
    }

    private boolean allNo(ListNode[] lists) {
        boolean b = true;
        for (ListNode list : lists) {
            if (list != null) {
                b = false;
            }
        }
        return b;
    }

    public static void main(String[] args) {

        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = new ListNode(1);
        listNodes[0].next = new ListNode(4);
        listNodes[0].next.next = new ListNode(5);

        listNodes[1] = new ListNode(2);
        listNodes[1].next = new ListNode(6);

        listNodes[2] = new ListNode(1);
        listNodes[2].next = new ListNode(3);
        listNodes[2].next.next = new ListNode(4);

        ListNode listNode = new Solution().mergeKLists(listNodes);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
