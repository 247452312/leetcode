/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-29 14:40
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        //提前移动的指针
        ListNode last = null;
        if (temp.next != null) {
            last = temp.next;
        }
        while (last != null && last.next != null) {
            ListNode last_before = last;
            if (last.next != null) {
                last = last.next.next;
            } else {
                last = null;
            }
            ListNode tt = last_before.next;

            last_before.next = last;

            tt.next = temp.next;
            temp.next = tt;

            temp = temp.next;


        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(1);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(5);
        listNode1.next.next.next.next = new ListNode(6);
        listNode1.next.next.next.next.next = new ListNode(4);
        listNode1.next.next.next.next.next.next = new ListNode(7);
        ListNode listNode = new Solution().oddEvenList(listNode1);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
