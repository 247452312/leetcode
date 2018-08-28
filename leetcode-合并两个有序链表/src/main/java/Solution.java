/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-28 09:47
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode listNode = new ListNode(0);
        ListNode listNode1 = listNode;
        int k = 0;
        while (true) {
            if (l1.val > l2.val) {
                listNode1.next = l2;
                listNode1 = listNode1.next;
                l2 = l2.next;
            } else {
                listNode1.next = l1;
                listNode1 = listNode1.next;
                l1 = l1.next;
            }
            if (l1 == null) {
                k = 1;
                break;
            }
            if (l2 == null) {
                k = 2;
                break;
            }
        }
        if (k == 1) {
            listNode1.next = l2;
        }
        if (k == 2) {
            listNode1.next = l1;
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(5);
        listNode.next.next.next = new ListNode(6);


        ListNode listNode2 = new ListNode(3);
        listNode2.next = new ListNode(4);
        listNode2.next.next = new ListNode(5);
        ListNode listNode1 = solution.mergeTwoLists(listNode, listNode2);

        System.out.println(listNode1.val);

        while (listNode1.next != null) {
            System.out.println(listNode1.next.val);
            listNode1 = listNode1.next;
        }

    }

    public ListNode batter(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        if (l1.val <= l2.val) {
            head = l1;
            head.next = batter(l1.next, l2);
        } else {
            head = l2;
            head.next = batter(l2.next, l1);
        }
        return head;
    }
}
