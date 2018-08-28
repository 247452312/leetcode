/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-28 09:26
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        ListNode start = head;

        for (int i = 0; i < n; i++) {
            if (temp.next != null) {
                temp = temp.next;
            } else {
                if (n - i == 1) {
                    return head.next;
                }
                return null;
            }
        }
        while (temp.next != null) {
            temp = temp.next;
            start = start.next;
        }
        start.next = start.next.next;
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(5);
        solution.removeNthFromEnd(listNode, 2);

        System.out.println(listNode.val);

        while (listNode.next != null) {
            System.out.println(listNode.next.val);
            listNode = listNode.next;
        }

    }



    public ListNode batter(ListNode head, int n) {
        if (n == 0) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy, cur = dummy;
        while( n >= 0 && cur != null) {
            cur = cur.next;
            n --;
        }
        while (cur != null) {
            pre = pre.next;
            cur = cur.next;
        }

        pre.next = pre.next.next;

        return dummy.next;
    }
}
