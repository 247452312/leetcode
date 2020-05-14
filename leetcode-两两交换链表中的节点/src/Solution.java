/**
 * @author uhyils <247452312@qq.com>
 * @date 文件创建日期 2020年03月25日 15时37分
 */
public class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head.next;
        ListNode p = head;
        ListNode last = new ListNode(0);
        while (p != null && p.next != null) {
            ListNode p1 = p;
            ListNode p2 = p.next;
            p = p2.next;
            p1.next = p2.next;
            p2.next = p1;
            last.next = p2;
            last = p1;
        }
        return result;

    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode p = node;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        ListNode listNode = new Solution().swapPairs(node);
        while (listNode != null) {
            System.out.print(listNode.val + " ->");
            listNode = listNode.next;
        }
        System.out.println();
    }


}
